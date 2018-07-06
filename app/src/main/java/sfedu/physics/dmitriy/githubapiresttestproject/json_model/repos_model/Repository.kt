package sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repository {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("private")
    @Expose
    var isPrivate: Boolean = false

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("clone_url")
    @Expose
    var clone_url: String? = null

    @SerializedName("html_url")
    @Expose
    var html_url: String? = null

    constructor() {}

    constructor(name: String, isPrivate: Boolean, description: String, language: String, clone_url: String, html_url: String) {

        this.name = name
        this.isPrivate = isPrivate
        this.description = description
        this.language = language
        this.clone_url = clone_url
        this.html_url = html_url
    }
}