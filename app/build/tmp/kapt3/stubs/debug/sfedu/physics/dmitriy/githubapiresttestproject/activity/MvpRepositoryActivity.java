package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0002J\u0016\u00102\u001a\u00020/2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\u0012\u00106\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020/H\u0014J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006?"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/activity/MvpRepositoryActivity;", "Lcom/arellomobile/mvp/MvpAppCompatActivity;", "Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/repositpries/RepositoriesView;", "()V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "repositoriesPresenter", "Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/repositpries/RepositoriesPresenter;", "getRepositoriesPresenter", "()Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/repositpries/RepositoriesPresenter;", "setRepositoriesPresenter", "(Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/repositpries/RepositoriesPresenter;)V", "repositoryAdapter", "Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/RepositoryAdapter;", "getRepositoryAdapter", "()Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/RepositoryAdapter;", "setRepositoryAdapter", "(Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/RepositoryAdapter;)V", "repositoryDao", "Lsfedu/physics/dmitriy/githubapiresttestproject/realmDAO/RepositoryDao;", "getRepositoryDao", "()Lsfedu/physics/dmitriy/githubapiresttestproject/realmDAO/RepositoryDao;", "setRepositoryDao", "(Lsfedu/physics/dmitriy/githubapiresttestproject/realmDAO/RepositoryDao;)V", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "userName", "", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "configureActionBar", "", "configureViews", "initViews", "loadRepositoriesByQuery", "repositories", "", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/repos_model/Repository;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onErrorLoadingRepositories", "throwable", "", "onLoadingFinished", "onStartLoading", "app_debug"})
public final class MvpRepositoryActivity extends com.arellomobile.mvp.MvpAppCompatActivity implements sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesView {
    @org.jetbrains.annotations.NotNull()
    public android.support.v7.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.NotNull()
    public android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    @org.jetbrains.annotations.NotNull()
    public android.app.ProgressDialog progressDialog;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userName;
    @org.jetbrains.annotations.NotNull()
    public sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.RepositoryDao repositoryDao;
    @org.jetbrains.annotations.NotNull()
    @com.arellomobile.mvp.presenter.InjectPresenter()
    public sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter repositoriesPresenter;
    @org.jetbrains.annotations.Nullable()
    private sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter repositoryAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v4.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public final void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull()
    android.support.v4.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.ProgressDialog getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.NotNull()
    android.app.ProgressDialog p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.RepositoryDao getRepositoryDao() {
        return null;
    }
    
    public final void setRepositoryDao(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.RepositoryDao p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter getRepositoriesPresenter() {
        return null;
    }
    
    public final void setRepositoriesPresenter(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter getRepositoryAdapter() {
        return null;
    }
    
    public final void setRepositoryAdapter(@org.jetbrains.annotations.Nullable()
    sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStartLoading() {
    }
    
    @java.lang.Override()
    public void loadRepositoriesByQuery(@org.jetbrains.annotations.NotNull()
    java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository> repositories) {
    }
    
    @java.lang.Override()
    public void onErrorLoadingRepositories(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    @java.lang.Override()
    public void onLoadingFinished() {
    }
    
    private final void initViews() {
    }
    
    private final void configureViews() {
    }
    
    private final void configureActionBar() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public MvpRepositoryActivity() {
        super();
    }
}