package sfedu.physics.dmitriy.githubapiresttestproject.application

import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

    companion object {

        val BASE_URL = "https://api.github.com"

        val rxJavaRetrofit: Retrofit
            get() {

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val httpClient1 = OkHttpClient.Builder()
                httpClient1.addInterceptor(logging)

                return Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(httpClient1.build())
                        .build()


            }
    }
}
