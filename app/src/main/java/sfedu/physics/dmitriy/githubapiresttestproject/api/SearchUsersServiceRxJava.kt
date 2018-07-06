package sfedu.physics.dmitriy.githubapiresttestproject.api


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse

interface SearchUsersServiceRxJava {
    @get:GET("/search/users?q=language:java+location:russia")
    val initUsers: Observable<UserResponse>

    @GET("/search/users")
    fun getUsersByQuery(@Query(value = "q", encoded = true) query: String): Observable<UserResponse>

    @GET("/search/users")
    fun getUsersByQueryAndPage(@Query(value = "q", encoded = true) query: String, @Query(value = "page", encoded = true) pageNumber: Int): Observable<UserResponse>
}
