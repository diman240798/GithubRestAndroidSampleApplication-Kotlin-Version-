package sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {

    @SerializedName("items")
    @Expose
    var users: List<User>? = null

    @SerializedName("total_count")
    @Expose
    var totalCount: Int = 0
}
