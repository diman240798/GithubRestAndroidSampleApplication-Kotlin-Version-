package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersPresenter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersView;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse;
import sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.UserDAO;
import sfedu.physics.dmitriy.githubapiresttestproject.utils.NetWorkUtils;

public class MvpUsersActivity extends MvpAppCompatActivity implements UsersView {


    @InjectPresenter
    UsersPresenter usersPresenter;


    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressDialog progressDialog;


    // Search Views
    private RelativeLayout relativeLayout;
    private EditText search_location, search_language;
    private Button start_search_button;
    private String userLocation;
    private String userProgrammingLanguage;

    // Some User Data
    private UserAdapter userAdapter;
    private int pageNumber = 1;
    private int pageLimit = 100;
    UserDAO userDAO;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        userDAO = new UserDAO();

        initViews();
        configureViews();
        initAndConfigureSearchViews();

        boolean networkConnected = NetWorkUtils.INSTANCE.isNetworkConnected(this);
        if (networkConnected) {
            usersPresenter.loadUsersByQuery();
            userDAO.deleteAllUsers();
        } else {
            List<User> users = userDAO.loadAllUsers();
            userAdapter = new UserAdapter(this, users);
            recyclerView.setAdapter(userAdapter);
            swipeRefreshLayout.setEnabled(false);
        }

    }

    @Override
    public void onStartLoading() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Github Users...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void loadUsersByQuery(UserResponse userResponse) {
        List<User> users = userResponse.getUsers();
        userAdapter = new UserAdapter(getApplicationContext(), users);
        pageLimit = userResponse.getTotalCount();
        userAdapter.setOnLoadMoreListener(() -> {
            if (pageNumber <= pageLimit) {
                pageNumber += 1;
                usersPresenter.loadMoreUsers(pageNumber);
            }
        });
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onErrorLoadingUsers(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        onLoadingFinished();
    }

    @Override
    public void onLoadingFinished() {
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.hide();
        progressDialog.dismiss();
        pageNumber = 1;
    }

    @Override
    public void loadMoreUsers(UserResponse userResponse) {
        List<User> newUsers = userResponse.getUsers();
        userAdapter.getUsers().addAll(newUsers);
        recyclerView.post(() -> userAdapter.notifyDataSetChanged());
        userAdapter.endLoading();
        userAdapter.setNoMore();
    }


    private void initViews() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.users_swipeContainer);
        recyclerView = (RecyclerView) findViewById(R.id.users_recyclerView);
    }

    private void configureViews() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        swipeRefreshLayout.setOnRefreshListener(() -> {
            usersPresenter.loadUsersByQuery();
            Toast.makeText(this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
        });
    }

    private void initAndConfigureSearchViews() {
        relativeLayout = (RelativeLayout) findViewById(R.id.users_search_layoutRL);
        search_location = (EditText) findViewById(R.id.users_search_locationET);
        search_language = (EditText) findViewById(R.id.users_search_languageET);
        start_search_button = (Button) findViewById(R.id.users_search_startBT);

        start_search_button.setOnClickListener(v -> {

            userLocation = search_location.getText().toString();
            userProgrammingLanguage = search_language.getText().toString();
            usersPresenter.loadUsersByLocationAndLanguage(userLocation, userProgrammingLanguage);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.users_action_search, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        menuItem.setOnMenuItemClickListener(item -> {
            int relativeLayoutVisibility = relativeLayout.getVisibility();
            switch (relativeLayoutVisibility) {
                case View.GONE:
                    relativeLayout.setVisibility(View.VISIBLE);
                    return true;
                case View.VISIBLE:
                    relativeLayout.setVisibility(View.GONE);
                    return true;
                default:
                    return false;
            }
        });

        return true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        usersPresenter.check_if_disposable_is_null_or_unsubscribe();
        userDAO.saveUsers(userAdapter.getUsers());
        userDAO.closeConnection();
    }
}
