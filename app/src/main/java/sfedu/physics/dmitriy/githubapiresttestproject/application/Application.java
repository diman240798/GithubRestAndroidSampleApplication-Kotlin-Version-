package sfedu.physics.dmitriy.githubapiresttestproject.application;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Application extends android.app.Application {
    public static final String BASE_URL = "https://api.github.com";

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static Retrofit rxJavaRetrofit;

    public static Retrofit getRxJavaClient() {
        if (rxJavaRetrofit == null) {
            rxJavaRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return rxJavaRetrofit;
    }
}
