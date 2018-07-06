package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/mvp/users/UsersModel;", "", "()V", "searchUsersServiceRxJava", "Lsfedu/physics/dmitriy/githubapiresttestproject/api/SearchUsersServiceRxJava;", "kotlin.jvm.PlatformType", "loadMoreUsers", "Lio/reactivex/Observable;", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/UserResponse;", "query", "", "pageNumber", "", "loadUsersByQuery", "app_debug"})
public final class UsersModel {
    private final sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersServiceRxJava searchUsersServiceRxJava = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse> loadMoreUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int pageNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse> loadUsersByQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    public UsersModel() {
        super();
    }
}