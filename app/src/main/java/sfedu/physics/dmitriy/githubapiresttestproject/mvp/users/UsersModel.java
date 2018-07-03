package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public class UsersModel {

    private SearchUsersServiceRxJava searchUsersServiceRxJava = Application.getRxJavaClient().create(SearchUsersServiceRxJava.class);

    public String createQueryByLocationAndLanguage(String userLocation, String userProgrammingLanguage) {
        StringBuilder query = new StringBuilder();
        if (!userLocation.isEmpty())
            query.append(String.format("location:%s+", userLocation));
        if (!userProgrammingLanguage.isEmpty())
            query.append(String.format("language:%s", userProgrammingLanguage));

        return query.toString();
    }

    public Observable<UserResponse> loadMoreUsers(String query, int pageNumber) {

        return searchUsersServiceRxJava.getUsersByQueryAndPage(query, pageNumber)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<UserResponse> loadUsersByQuery(String query) {

        return searchUsersServiceRxJava.getUsersByQuery(query)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread());

    }
}
