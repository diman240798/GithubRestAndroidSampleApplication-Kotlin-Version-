package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import io.reactivex.disposables.Disposable

@InjectViewState
class RepositoriesPresenter : MvpPresenter<RepositoriesView>() {

    val repositoriesModel: RepositoriesModel
    var disposable: Disposable? = null

    init {
        repositoriesModel = RepositoriesModel()
    }


    fun loadRepositoriesByUserLogin(userLogin: String) {
        viewState.onStartLoading()
        check_if_disposable_is_null_or_unsubscribe()
        disposable = repositoriesModel.loadRepositories(userLogin)
                .subscribe({ viewState.loadRepositoriesByQuery(it) },
                        { viewState.onErrorLoadingRepositories(it) },
                        { viewState.onLoadingFinished() })
    }

    fun check_if_disposable_is_null_or_unsubscribe() {
        if (disposable == null) {
            return
        } else if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }


}