package datanapps.retrofitopenweatherkotlin.services.network

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {


    private val BASE_URL = " https://reqres.in"

    private val TIMEOUT = 10

    var retrofit: Retrofit? = null
    /*
    This public static method will return Retrofit client
    anywhere in the appplication
    */
    val retrofitClient: Retrofit
        get() {
            if (retrofit == null) {
                val okHttpClientBuilder = OkHttpClient.Builder()
                okHttpClientBuilder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClientBuilder.build())
                        .build()
            }
            return retrofit!!
        }

}
