package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries


import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository

@StateStrategyType(AddToEndStrategy::class)
interface RepositoriesView : MvpView {

    fun onStartLoading()
    fun loadRepositoriesByQuery(repositories: List<Repository>)
    fun onErrorLoadingRepositories(throwable: Throwable)
    fun onLoadingFinished()

}
