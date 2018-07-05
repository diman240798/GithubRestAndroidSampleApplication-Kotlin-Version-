package sfedu.physics.dmitriy.githubapiresttestproject.activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesView;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository;
import sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.RepositoryDao;
import sfedu.physics.dmitriy.githubapiresttestproject.utils.NetWorkUtils;

public class MvpRepositoryActivity extends MvpAppCompatActivity implements RepositoriesView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    String userName;
    RepositoryDao repositoryDao;

    @InjectPresenter
    RepositoriesPresenter repositoriesPresenter;

    private RepositoryAdapter repositoryAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        repositoryDao = new RepositoryDao();

        // Check If intent came with userLogin or Quit if not
        userName = getIntent().getAction();
        if (userName == null) {
            Toast.makeText(this, "UserLogin is not loaded", Toast.LENGTH_SHORT).show();
            finish();
        }

        initViews();
        configureViews();
        configureActionBar();

        boolean networkConnected = NetWorkUtils.isNetworkConnected(this);
        if (networkConnected) {
            repositoriesPresenter.loadRepositoriesByUserLogin(userName);
            repositoryDao.deleteAllRepositories();
        } else {
            List<Repository> repositories = repositoryDao.loadAllRepositories();
            repositoryAdapter = new RepositoryAdapter(this, repositories);
            recyclerView.setAdapter(repositoryAdapter);
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
    public void loadRepositoriesByQuery(List<Repository> repositories) {
        repositoryAdapter = new RepositoryAdapter(getApplicationContext(), repositories);
        recyclerView.setAdapter(repositoryAdapter);
    }

    @Override
    public void onErrorLoadingRepositories(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        onLoadingFinished();
    }

    @Override
    public void onLoadingFinished() {
        Toast.makeText(this, "Repositories are Loaded", Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.hide();
        progressDialog.dismiss();
    }



    private void initViews() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.repo_swipeContainer);
        recyclerView = (RecyclerView) findViewById(R.id.repo_recyclerView);
    }

    private void configureViews() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //recyclerView.smoothScrollToPosition(0);



        swipeRefreshLayout.setOnRefreshListener(() -> {
                    repositoriesPresenter.loadRepositoriesByUserLogin(userName);
                    Toast.makeText(MvpRepositoryActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
                }
        );


    }

    private void configureActionBar() {
        getSupportActionBar().setTitle("UserDbModel Repositories");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        repositoriesPresenter.check_if_disposable_is_null_or_unsubscribe();
        repositoryDao.saveRepositories(repositoryAdapter.getRepositories());
        repositoryDao.closeConnection();
    }
}
