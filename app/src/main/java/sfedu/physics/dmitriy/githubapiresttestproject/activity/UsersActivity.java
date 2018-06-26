package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

import static sfedu.physics.dmitriy.githubapiresttestproject.StringUtils.*;
public class UsersActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    TextView disconnected;

    SwipeRefreshLayout swipeRefreshLayout;

    ProgressDialog progressDialog;

    // Search Views
    RelativeLayout relativeLayout;
    EditText search_location, search_language;
    Button start_search_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        initViews();
        initAndConfigureSearchViews();
        configureViews();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            loadInitJsonViaRxJava();
            Toast.makeText(UsersActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
        });
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
           choseJsonMethodForSearch(userLocation, userProgrammingLanguage);
        });
    }

    private void choseJsonMethodForSearch(String userLocation, String userProgrammingLanguage) {
        if (checkStringIsNotNullOrEmpty(userLocation) && checkStringIsNotNullOrEmpty(userProgrammingLanguage))
            loadJsonByLocationAndLanguage(userLocation, userProgrammingLanguage);
        else if (checkStringIsNotNullOrEmpty(userLocation) && checkStringIsNullOrEmpty(userProgrammingLanguage))
            loadJsonByLocation(userLocation);
        else if (checkStringIsNullOrEmpty(userLocation) && checkStringIsNotNullOrEmpty(userProgrammingLanguage))
            loadJsonByProgrammingLanguage(userProgrammingLanguage);
    }

    private void configureViews() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Github Users...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        loadInitJsonViaRxJava();
    }

    private void loadInitJsonViaRxJava() {
        SearchUsersServiceRxJava searchUsersServiceRxJava = Application.getRxJavaClient().create(SearchUsersServiceRxJava.class);
        searchUsersServiceRxJava.getInitUsers()
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);

    }

    private void loadJsonByLocationAndLanguage(String userLocation, String userProgrammingLanguage) {
        loadUsersByQuery(String.format("location:%s+language:%s", userLocation, userProgrammingLanguage));
    }

    private void loadJsonByLocation(String userLocation) {
        loadUsersByQuery(String.format("location:%s", userLocation));
    }

    private void loadJsonByProgrammingLanguage(String userProgrammingLanguage) {
        loadUsersByQuery(String.format("language:%s", userProgrammingLanguage));
    }
    private void loadUsersByQuery(String query) {
        SearchUsersServiceRxJava searchUsersServiceRxJava = Application.getRxJavaClient().create(SearchUsersServiceRxJava.class);
        searchUsersServiceRxJava.getUsersByQuery(query)
                .subscribeOn(Schedulers.io())
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
    }

    private void handleError(Throwable throwable) {
        Log.d("ERROR", throwable.getMessage());
        Toast.makeText(UsersActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
        disconnected.setVisibility(View.VISIBLE);
        progressDialog.hide();
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

/*private void loadJSON() {
        try {
            SearchUsersService apiSearchUsersService =
                    Application.getClient().create(SearchUsersService.class);
            Call<UserResponse> call = apiSearchUsersService.getInitUsers();
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    List<User> users = response.body().getUsers();
                    recyclerView.setAdapter(new UserAdapter(getApplicationContext(), users));
                    swipeRefreshLayout.setRefreshing(false);
                    progressDialog.hide();
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Log.d("ERROR", t.getMessage());
                    Toast.makeText(UsersActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                    disconnected.setVisibility(View.VISIBLE);
                    progressDialog.hide();
                }
            });
        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
            Toast.makeText(UsersActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }*/