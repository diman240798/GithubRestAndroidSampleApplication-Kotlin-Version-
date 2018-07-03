package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

@StateStrategyType(AddToEndStrategy.class)
public interface UsersView extends MvpView {
    void onStartLoading();

    void loadUsersByQuery(UserResponse userResponse);
    void onErrorLoadingUsers(Throwable throwable);
    void onLoadingFinished();

    void loadMoreUsers(UserResponse userResponse);
}
