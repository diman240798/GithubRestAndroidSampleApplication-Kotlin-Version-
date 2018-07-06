package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/users/UsersPresenter;", "Lcom/arellomobile/mvp/MvpPresenter;", "Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/users/UsersView;", "()V", "disposable", "Lio/reactivex/disposables/Disposable;", "initQuery", "", "query", "usersModel", "Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/users/UsersModel;", "check_if_disposable_is_null_or_unsubscribe", "", "loadMoreUsers", "pageNumber", "", "loadUsersByLocationAndLanguage", "userLocation", "userProgrammingLanguage", "loadUsersByQuery", "app_debug"})
@com.arellomobile.mvp.InjectViewState()
public final class UsersPresenter extends com.arellomobile.mvp.MvpPresenter<sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersView> {
    private final sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersModel usersModel = null;
    private final java.lang.String initQuery = "language:java+location:russia";
    private java.lang.String query;
    private io.reactivex.disposables.Disposable disposable;
    
    public final void loadUsersByLocationAndLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String userLocation, @org.jetbrains.annotations.NotNull()
    java.lang.String userProgrammingLanguage) {
    }
    
    public final void check_if_disposable_is_null_or_unsubscribe() {
    }
    
    public final void loadUsersByQuery() {
    }
    
    public final void loadMoreUsers(int pageNumber) {
    }
    
    public UsersPresenter() {
        super();
    }
}