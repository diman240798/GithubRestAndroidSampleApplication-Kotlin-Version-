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

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchRepositoryServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.repos_model.Repository;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;

public class RepositoryActivity extends RxAppCompatActivity {

    RecyclerView recyclerView;

    TextView disconnected;

    SwipeRefreshLayout swipeRefreshLayout;

    User user;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        // Check If intent came with userLogin or Quit;
        String userName = getIntent().getAction();
        if (userName == null) {
            Toast.makeText(this, "UserLogin is not loaded", Toast.LENGTH_SHORT).show();
            finish();
        }

        initViews();
        configureViews();
        configureActionBar();
        loadJsonViaRxJava(userName);

        swipeRefreshLayout.setOnRefreshListener(() -> {
                    loadJsonViaRxJava(userName);
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

    private void configureActionBar() {
        getSupportActionBar().setTitle("User Repositories");
    }

    private void loadJsonViaRxJava(String userLogin) {
        SearchRepositoryServiceRxJava searchRepositoryServiceRxJava
                = Application.getRxJavaClient().create(SearchRepositoryServiceRxJava.class);
        searchRepositoryServiceRxJava.getUserRepositoriesByLogin(userLogin)
                .subscribeOn(Schedulers.io())
                .compose(bindToLifecycle())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
    }

    private void handleResult(List<Repository> repositories) {
        recyclerView.setAdapter(new RepositoryAdapter(getApplicationContext(), repositories));
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.hide();
        progressDialog.dismiss();
    }

    private void handleError(Throwable throwable) {
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.hide();
        progressDialog.dismiss();
    }

}
