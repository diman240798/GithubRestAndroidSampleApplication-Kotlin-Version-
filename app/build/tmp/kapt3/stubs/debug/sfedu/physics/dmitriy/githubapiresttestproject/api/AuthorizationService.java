package sfedu.physics.dmitriy.githubapiresttestproject.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\'\u00a8\u0006\t"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/api/AuthorizationService;", "", "getAccessToken", "Lretrofit2/Call;", "Lsfedu/physics/dmitriy/githubapiresttestproject/api/AccessToken;", "client_id", "", "client_secret", "code", "app_debug"})
public abstract interface AuthorizationService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "/login/oauth/access_token")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<sfedu.physics.dmitriy.githubapiresttestproject.api.AccessToken> getAccessToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "client_id")
    java.lang.String client_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "client_secret")
    java.lang.String client_secret, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "code")
    java.lang.String code);
}