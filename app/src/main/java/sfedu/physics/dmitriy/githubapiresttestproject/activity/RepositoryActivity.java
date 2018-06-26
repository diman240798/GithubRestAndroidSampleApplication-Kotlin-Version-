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
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchRepositoriesService;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.repos_model.Repository;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;

public class RepositoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    TextView disconnected;

    SwipeRefreshLayout swipeRefreshLayout;

    User user;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        String userName = getIntent().getAction();
        if (userName == null) {
            Toast.makeText(this, "UserLOgin is not loaded", Toast.LENGTH_SHORT).show();
            finish();
        }
        initViews();
        configureViews();
        loadJSON(userName);

        swipeRefreshLayout.setOnRefreshListener(() -> {
                    loadJSON(userName);
                    Toast.makeText(RepositoryActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
                }
        );
    }

    private void initViews() {
        disconnected = (TextView) findViewById(R.id.repo_disconnectedTV);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.repo_swipeContainer);
        recyclerView = (RecyclerView) findViewById(R.id.repo_recyclerView);
    }

    private void configureViews() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching User Repositories...");
        progressDialog.setCancelable(false);
        progressDialog.show();


    }

    private void loadJSON(String userLogin) {
        try {

            SearchRepositoriesService searchRepositoriesService
                    = Application.getClient().create(SearchRepositoriesService.class);

            Call<List<Repository>> userRepositories = searchRepositoriesService.getUserRepositoriesByLogin(userLogin);
            userRepositories.enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                    List<Repository> repositories = response.body();
                    recyclerView.setAdapter(new RepositoryAdapter(getApplicationContext(), repositories));
                    swipeRefreshLayout.setRefreshing(false);
                    progressDialog.hide();
                }

                @Override
                public void onFailure(Call<List<Repository>> call, Throwable t) {
                    Log.d("ERROR", t.getMessage());
                    Toast.makeText(RepositoryActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                    disconnected.setVisibility(View.VISIBLE);
                    progressDialog.hide();
                }
            });
        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
            Toast.makeText(RepositoryActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}