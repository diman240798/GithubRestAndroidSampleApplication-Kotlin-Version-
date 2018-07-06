package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/users/UsersView;", "Lcom/arellomobile/mvp/MvpView;", "loadMoreUsers", "", "userResponse", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/UserResponse;", "loadUsersByQuery", "onErrorLoadingUsers", "throwable", "", "onLoadingFinished", "onStartLoading", "app_debug"})
@com.arellomobile.mvp.viewstate.strategy.StateStrategyType(value = com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class)
public abstract interface UsersView extends com.arellomobile.mvp.MvpView {
    
    public abstract void onStartLoading();
    
    public abstract void loadUsersByQuery(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse userResponse);
    
    public abstract void onErrorLoadingUsers(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable);
    
    public abstract void onLoadingFinished();
    
    public abstract void loadMoreUsers(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse userResponse);
}