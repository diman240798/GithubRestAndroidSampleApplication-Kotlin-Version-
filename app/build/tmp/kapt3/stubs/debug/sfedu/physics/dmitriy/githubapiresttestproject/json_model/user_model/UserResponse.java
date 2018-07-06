package sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/UserResponse;", "", "()V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "users", "", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/User;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "app_debug"})
public final class UserResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "items")
    private java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> users;
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "total_count")
    private int totalCount;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> getUsers() {
        return null;
    }
    
    public final void setUsers(@org.jetbrains.annotations.Nullable()
    java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> p0) {
    }
    
    public final int getTotalCount() {
        return 0;
    }
    
    public final void setTotalCount(int p0) {
    }
    
    public UserResponse() {
        super();
    }
}