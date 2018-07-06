package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchRepositoryServiceRxJava
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository

class RepositoriesModel {

    private val searchRepositoryServiceRxJava = Application.Companion.rxJavaRetrofit.create(SearchRepositoryServiceRxJava::class.java)

    fun loadRepositories(userLogin: String): Observable<List<Repository>> {

        return searchRepositoryServiceRxJava.getUserRepositoriesByLogin(userLogin)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
    }
}
