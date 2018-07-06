package sfedu.physics.dmitriy.githubapiresttestproject.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthorizationService {

    @Headers("Accept: application/json")
    @POST("/login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(
            @Field("client_id") client_id: String,
            @Field("client_secret") client_secret: String,
            @Field("code") code: String

    ): Call<AccessToken>

}
