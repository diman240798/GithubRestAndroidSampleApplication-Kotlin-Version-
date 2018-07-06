package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/repositpries/RepositoriesView;", "Lcom/arellomobile/mvp/MvpView;", "loadRepositoriesByQuery", "", "repositories", "", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/repos_model/Repository;", "onErrorLoadingRepositories", "throwable", "", "onLoadingFinished", "onStartLoading", "app_debug"})
@com.arellomobile.mvp.viewstate.strategy.StateStrategyType(value = com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class)
public abstract interface RepositoriesView extends com.arellomobile.mvp.MvpView {
    
    public abstract void onStartLoading();
    
    public abstract void loadRepositoriesByQuery(@org.jetbrains.annotations.NotNull()
    java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository> repositories);
    
    public abstract void onErrorLoadingRepositories(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable);
    
    public abstract void onLoadingFinished();
}