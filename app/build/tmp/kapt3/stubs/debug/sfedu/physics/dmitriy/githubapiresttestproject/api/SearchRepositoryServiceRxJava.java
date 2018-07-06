package sfedu.physics.dmitriy.githubapiresttestproject.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/api/SearchRepositoryServiceRxJava;", "", "getUserRepositoriesByLogin", "Lio/reactivex/Observable;", "", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/repos_model/Repository;", "user_login", "", "app_debug"})
public abstract interface SearchRepositoryServiceRxJava {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/users/{user_login}/repos")
    public abstract io.reactivex.Observable<java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository>> getUserRepositoriesByLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "user_login")
    java.lang.String user_login);
}