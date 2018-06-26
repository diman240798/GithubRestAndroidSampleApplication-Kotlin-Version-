package sfedu.physics.dmitriy.githubapiresttestproject.api;

import retrofit2.Call;
import retrofit2.http.GET;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public interface SearchUsersService {
    @GET("/search/users?q=language:java+location:lagos")
    Call<UserResponse> getItems();
}
