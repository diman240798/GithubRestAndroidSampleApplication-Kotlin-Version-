package sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("login")
    @Expose
    var login: String? = null

    @SerializedName("avatar_url")
    @Expose
    var avatarURL: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlURL: String? = null

    var bitmapData: ByteArray? = null

    constructor() {}

    constructor(login: String, avatarURL: String, htmlURL: String) {
        this.login = login
        this.avatarURL = avatarURL
        this.htmlURL = htmlURL
    }
}
