package sfedu.physics.dmitriy.githubapiresttestproject.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public interface SearchUsersServiceRxJava {
    @GET("/search/users?q=language:java+location:russia")
    Observable<UserResponse> getInitUsers();

    @GET("/search/users")
    Observable<UserResponse> getUsersByQuery(@Query(value = "q", encoded = true) String query);
}
