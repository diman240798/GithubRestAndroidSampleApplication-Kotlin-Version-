package sfedu.physics.dmitriy.githubapiresttestproject.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sfedu.physics.dmitriy.githubapiresttestproject.repos_model.Repository;

public interface SearchRepositoriesService {
    @GET("/users/{user_login}/repos")
    Call<List<Repository>> getUserRepositoriesByLogin(@Path("user_login") String user_login);
}
