package sfedu.physics.dmitriy.githubapiresttestproject.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository

interface SearchRepositoryServiceRxJava {
    @GET("/users/{user_login}/repos")
    fun getUserRepositoriesByLogin(@Path("user_login") user_login: String): Observable<List<Repository>>
}
