package datanapps.retrofitopenweatherkotlin.services.users

import datanapps.retrofitopenweatherkotlin.services.users.model.Weather
import datanapps.retrofitopenweatherkotlin.services.users.model.WeatherFarecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * API for getting weather from https://darksky.net/
 */
interface APIWeather {


    @GET("{latitude},{longitude}")
    fun getWeather(@Path("latitude") latitude: String,
                   @Path("longitude") longitude: String): Call<Weather>


    @GET("/data/2.5/forecast?")
    fun getWeatherByCityName5Days(@QueryMap options: Map<String, String>): Call<WeatherFarecast>

    @GET("api/users?")
    fun getUserList(@QueryMap options: Map<String, String>): Call<BaseUser>
}
