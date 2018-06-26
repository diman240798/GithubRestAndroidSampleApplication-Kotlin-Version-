package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersService;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public class UsersActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    TextView disconnected;

    SwipeRefreshLayout swipeRefreshLayout;

    User user;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        configureViews();

        swipeRefreshLayout.setOnRefreshListener(
                () -> {
                    loadJSON();
                    Toast.makeText(UsersActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
                }
        );
    }

    private void configureViews() {

        disconnected = (TextView) findViewById(R.id.users_disconnectedTV);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.users_swipeContainer);
        recyclerView = (RecyclerView) findViewById(R.id.users_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Github Users...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        loadJSON();
    }

    private void loadJSON() {
        try {
            SearchUsersService apiSearchUsersService =
                    Application.getClient().create(SearchUsersService.class);
            Call<UserResponse> call = apiSearchUsersService.getItems();
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
    }
}
