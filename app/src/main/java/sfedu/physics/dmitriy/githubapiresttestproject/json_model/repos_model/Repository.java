package sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("private")
    @Expose
    private boolean isPrivate;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("clone_url")
    @Expose
    private String clone_url;

    @SerializedName("html_url")
    @Expose
    private String html_url;

    public Repository() {
    }

    public Repository(String name, boolean isPrivate, String description, String language, String clone_url, String html_url) {

        this.name = name;
        this.isPrivate = isPrivate;
        this.description = description;
        this.language = language;
        this.clone_url = clone_url;
        this.html_url = html_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}