package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository;

@StateStrategyType(AddToEndStrategy.class)
public interface RepositoriesView extends MvpView {

    void onStartLoading();
    void loadRepositoriesByQuery(List<Repository> repositories);
    void onErrorLoadingRepositories(Throwable throwable);
    void onLoadingFinished();

}
