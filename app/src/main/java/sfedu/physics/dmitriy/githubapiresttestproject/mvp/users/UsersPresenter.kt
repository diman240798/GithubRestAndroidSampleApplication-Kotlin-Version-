package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import io.reactivex.disposables.Disposable
import sfedu.physics.dmitriy.githubapiresttestproject.utils.QueryUtils


@InjectViewState
class UsersPresenter : MvpPresenter<UsersView>() {

    private val usersModel: UsersModel

    private val initQuery = "language:java+location:russia"
    private var query = initQuery
    private var disposable: Disposable? = null

    init {
        usersModel = UsersModel()
    }


    fun loadUsersByLocationAndLanguage(userLocation: String, userProgrammingLanguage: String) {
        query = QueryUtils.createQueryByLocationAndLanguage(userLocation, userProgrammingLanguage)
        loadUsersByQuery()
    }

    fun check_if_disposable_is_null_or_unsubscribe() {
        if (disposable == null) {
            return
        } else if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

    fun loadUsersByQuery() {
        viewState.onStartLoading()
        check_if_disposable_is_null_or_unsubscribe()
        disposable = usersModel.loadUsersByQuery(query)
                .subscribe({ viewState.loadUsersByQuery(it) },
                        { viewState.onErrorLoadingUsers(it) },
                        { viewState.onLoadingFinished() })
    }

    fun loadMoreUsers(pageNumber: Int) {
        check_if_disposable_is_null_or_unsubscribe()
        disposable = usersModel.loadMoreUsers(query, pageNumber)
                .subscribe({ viewState.loadMoreUsers(it) },
                        { viewState.onErrorLoadingUsers(it) })
    }
}
