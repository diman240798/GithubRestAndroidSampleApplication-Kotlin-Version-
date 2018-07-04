package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchRepositoryServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.repos_model.Repository;

public class RepositoriesModel {

    private final SearchRepositoryServiceRxJava searchRepositoryServiceRxJava
            = Application.getRxJavaClient().create(SearchRepositoryServiceRxJava.class);

    public Observable<List<Repository>> loadRepositories(String userLogin) {

        return searchRepositoryServiceRxJava.getUserRepositoriesByLogin(userLogin)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
