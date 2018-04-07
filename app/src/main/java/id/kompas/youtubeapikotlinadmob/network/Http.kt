package id.kompas.youtubeapikotlinadmob.network

import id.co.imastudio.driverakbbontang.Service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by nandoseptianhusni on 2/10/18.
 */
object Http {

    val instance: Retrofit by lazy {


        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var okhttp = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        Retrofit.Builder().baseUrl("https://www.googleapis.com/")
                .client(okhttp)

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    }


    val retrofit: ApiService
        get() = instance.create(ApiService::class.java)



}

