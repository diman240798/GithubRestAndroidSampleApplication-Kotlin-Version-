package sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/User;", "", "()V", "login", "", "avatarURL", "htmlURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarURL", "()Ljava/lang/String;", "setAvatarURL", "(Ljava/lang/String;)V", "bitmapData", "", "getBitmapData", "()[B", "setBitmapData", "([B)V", "getHtmlURL", "setHtmlURL", "getLogin", "setLogin", "app_debug"})
public final class User {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "login")
    private java.lang.String login;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "avatar_url")
    private java.lang.String avatarURL;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "html_url")
    private java.lang.String htmlURL;
    @org.jetbrains.annotations.Nullable()
    private byte[] bitmapData;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLogin() {
        return null;
    }
    
    public final void setLogin(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarURL() {
        return null;
    }
    
    public final void setAvatarURL(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHtmlURL() {
        return null;
    }
    
    public final void setHtmlURL(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getBitmapData() {
        return null;
    }
    
    public final void setBitmapData(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    public User() {
        super();
    }
    
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarURL, @org.jetbrains.annotations.NotNull()
    java.lang.String htmlURL) {
        super();
    }
}