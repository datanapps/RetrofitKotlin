package datanapps.retrofitopenweatherkotlin.services.weather

import java.util.HashMap

import datanapps.retrofitopenweatherkotlin.services.network.NetworkClient
import datanapps.retrofitopenweatherkotlin.services.network.RetrofitEventListener
import datanapps.retrofitopenweatherkotlin.services.weather.model.WeatherFarecast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class ApiWeatherRestClient {


    companion object {
        val instance = ApiWeatherRestClient()
        private val API_KEY = "573ace94d18a7441b7237118bf789162"
    }

    private var mApiWeather: APIWeather? = null

    /**
     * Invoke getWeather via [Call] request.
     *
     * @param indianCityName of City.
     * @param retrofitEventListener of RetrofitEventListener.
     */
    fun getWeather(indianCityName: String, retrofitEventListener: RetrofitEventListener) {

        val retrofit = NetworkClient.retrofitClient
        mApiWeather = retrofit.create<APIWeather>(APIWeather::class.java)

        //     https://api.openweathermap.org/data/2.5/forecast?q=Robertsganj,in&appid=573ace94d18a7441b7237118bf789162&cnt=5&units=metric

        val data = HashMap<String, String>()
        data["q"] = "$indianCityName,IN"
        data["appid"] = API_KEY
        data["units"] = "metric"
        data["cnt"] = "15"


        val apiWeatherCall = mApiWeather!!.getWeatherByCityName5Days(data)
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */

        apiWeatherCall.enqueue(object : Callback<WeatherFarecast> {

            override fun onResponse(call: Call<WeatherFarecast>?, response: Response<WeatherFarecast>?) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response?.body() != null) {
                    retrofitEventListener.onSuccess(call, response?.body())
                }
            }
            override fun onFailure(call: Call<WeatherFarecast>?, t: Throwable?) {
                /*
                Error callback
                */
                retrofitEventListener.onError(call, t)
            }
        })

    }

}
