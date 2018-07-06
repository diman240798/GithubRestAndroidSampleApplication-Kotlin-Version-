package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse

@StateStrategyType(AddToEndStrategy::class)
interface UsersView : MvpView {
    fun onStartLoading()

    fun loadUsersByQuery(userResponse: UserResponse)
    fun onErrorLoadingUsers(throwable: Throwable)
    fun onLoadingFinished()

    fun loadMoreUsers(userResponse: UserResponse)
}
