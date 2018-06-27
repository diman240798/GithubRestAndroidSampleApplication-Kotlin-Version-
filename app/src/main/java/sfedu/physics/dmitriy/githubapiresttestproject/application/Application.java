package sfedu.physics.dmitriy.githubapiresttestproject.application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Application extends android.app.Application {

    public static final String BASE_URL = "https://api.github.com";

    private static Retrofit rxJavaRetrofit;

    public static Retrofit getRxJavaClient() {
        if (rxJavaRetrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient1 = new OkHttpClient.Builder();
            httpClient1.addInterceptor(logging);
            rxJavaRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient1.build())
                    .build();


        }
        return rxJavaRetrofit;
    }
}
