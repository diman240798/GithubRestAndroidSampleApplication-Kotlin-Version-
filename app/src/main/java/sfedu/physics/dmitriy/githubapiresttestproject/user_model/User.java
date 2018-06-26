package sfedu.physics.dmitriy.githubapiresttestproject.user_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatarURL;

    @SerializedName("html_url")
    @Expose
    private String htmlURL;

    public User(String login, String avatarURL, String htmlURL) {
        this.login = login;
        this.avatarURL = avatarURL;
        this.htmlURL = htmlURL;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }
}
