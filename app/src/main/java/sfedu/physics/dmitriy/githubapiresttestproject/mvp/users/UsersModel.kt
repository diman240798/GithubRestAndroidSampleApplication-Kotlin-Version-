package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sfedu.physics.dmitriy.githubapiresttestproject.api.SearchUsersServiceRxJava
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.UserResponse

class UsersModel {

    private val searchUsersServiceRxJava = Application.Companion.rxJavaRetrofit.create(SearchUsersServiceRxJava::class.java)


    fun loadMoreUsers(query: String, pageNumber: Int): Observable<UserResponse> {

        return searchUsersServiceRxJava.getUsersByQueryAndPage(query, pageNumber)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadUsersByQuery(query: String): Observable<UserResponse> {

        return searchUsersServiceRxJava.getUsersByQuery(query)
                .subscribeOn(Schedulers.io())
                .cache()
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())

    }
}


/*    public String createQueryByLocationAndLanguage(String userLocation, String userProgrammingLanguage) {
        StringBuilder query = new StringBuilder();
        if (!userLocation.isEmpty())
            query.append(String.format("location:%s+", userLocation));
        if (!userProgrammingLanguage.isEmpty())
            query.append(String.format("language:%s", userProgrammingLanguage));

        return query.toString();
    }*/