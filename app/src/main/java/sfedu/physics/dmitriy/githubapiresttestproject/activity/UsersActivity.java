package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public class UsersActivity extends RxAppCompatActivity {


    private RecyclerView recyclerView;

    private TextView disconnected;

    private SwipeRefreshLayout swipeRefreshLayout;

    private ProgressDialog progressDialog;

    // Search Views
    private RelativeLayout relativeLayout;
    private EditText search_location, search_language;
    private Button start_search_button;
    private StringBuilder query;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        initViews();
        initAndConfigureSearchViews();
        configureViews();
        loadInitJson();
    }

    private void initViews() {
        disconnected = (TextView) findViewById(R.id.users_disconnectedTV);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.users_swipeContainer);
        recyclerView = (RecyclerView) findViewById(R.id.users_recyclerView);
    }

    private void initAndConfigureSearchViews() {
        relativeLayout = (RelativeLayout) findViewById(R.id.users_search_layoutRL);
        search_location = (EditText) findViewById(R.id.users_search_locationET);
        search_language = (EditText) findViewById(R.id.users_search_languageET);

        start_search_button = (Button) findViewById(R.id.users_search_startBT);
        start_search_button.setOnClickListener(v -> {

            String userLocation = search_location.getText().toString();
            String userProgrammingLanguage = search_language.getText().toString();

            createQueryForSearch(userLocation, userProgrammingLanguage);
        });
    }

    private void createQueryForSearch(String userLocation, String userProgrammingLanguage) {
        query = new StringBuilder();
        if (!userLocation.isEmpty())
            query.append(String.format("location:%s+", userLocation));
        if (!userProgrammingLanguage.isEmpty())
            query.append(String.format("language:%s", userProgrammingLanguage));
        loadUsersByQuery(query.toString());
    }

    private void configureViews() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Github Users...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        swipeRefreshLayout.setOnRefreshListener(() -> {
            loadUsersByQuery(query == null ? null : query.toString());
            Toast.makeText(UsersActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
        });
    }


    private void loadUsersByQuery(String query) {
        if (query == null)
            loadInitJson();

        SearchUsersServiceRxJava searchUsersServiceRxJava = Application.getRxJavaClient().create(SearchUsersServiceRxJava.class);
        searchUsersServiceRxJava.getUsersByQuery(query)
                .subscribeOn(Schedulers.io())
                .compose(bindToLifecycle())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
    }

    private void loadInitJson() {
        SearchUsersServiceRxJava searchUsersServiceRxJava = Application.getRxJavaClient().create(SearchUsersServiceRxJava.class);
        searchUsersServiceRxJava.getInitUsers()
                .subscribeOn(Schedulers.io())
                .compose(bindToLifecycle())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
    }


    private void handleResult(UserResponse userResponse) {
        List<User> users = userResponse.getUsers();
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), users));
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.hide();
        progressDialog.dismiss();
    }

    private void handleError(Throwable throwable) {
        disconnected.setVisibility(View.VISIBLE);
        progressDialog.hide();
        progressDialog.dismiss();
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
}
