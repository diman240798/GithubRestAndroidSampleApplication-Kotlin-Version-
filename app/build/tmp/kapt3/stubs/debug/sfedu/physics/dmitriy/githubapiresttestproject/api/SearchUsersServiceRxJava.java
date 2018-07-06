package sfedu.physics.dmitriy.githubapiresttestproject.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\fH\'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/api/SearchUsersServiceRxJava;", "", "initUsers", "Lio/reactivex/Observable;", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/UserResponse;", "getInitUsers", "()Lio/reactivex/Observable;", "getUsersByQuery", "query", "", "getUsersByQueryAndPage", "pageNumber", "", "app_debug"})
public abstract interface SearchUsersServiceRxJava {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/search/users?q=language:java+location:russia")
    public abstract io.reactivex.Observable<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse> getInitUsers();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/search/users")
    public abstract io.reactivex.Observable<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse> getUsersByQuery(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q", encoded = true)
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/search/users")
    public abstract io.reactivex.Observable<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse> getUsersByQueryAndPage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q", encoded = true)
    java.lang.String query, @retrofit2.http.Query(value = "page", encoded = true)
    int pageNumber);
}