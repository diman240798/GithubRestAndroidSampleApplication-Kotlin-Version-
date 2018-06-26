package sfedu.physics.dmitriy.githubapiresttestproject.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sfedu.physics.dmitriy.githubapiresttestproject.repos_model.Repository;

public interface SearchRepositoryServiceRxJava {
    @GET("/users/{user_login}/repos")
    Observable<List<Repository>> getUserRepositoriesByLogin(@Path("user_login") String user_login);
}
