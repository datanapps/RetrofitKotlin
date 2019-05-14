package datanapps.retrofitopenweatherkotlin.services.users

import java.util.HashMap

import datanapps.retrofitopenweatherkotlin.services.network.NetworkClient
import datanapps.retrofitopenweatherkotlin.services.network.RetrofitEventListener
import datanapps.retrofitopenweatherkotlin.services.users.model.BaseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiUserRestClient {


    companion object {
        val instance = ApiUserRestClient()
        private val API_KEY = "573ace94d18a7441b7237118bf789162"
    }

    private var mApiWeather: APIUser? = null

    /**
     * Invoke getUserList via [Call] request.
     *
     * @param indianCityName of City.
     * @param retrofitEventListener of RetrofitEventListener.
     */
    fun getUserList(indianCityName: String, retrofitEventListener: RetrofitEventListener) {

        val retrofit = NetworkClient.retrofitClient
        mApiWeather = retrofit.create<APIUser>(APIUser::class.java)

        //     https://reqres.in/api/users?page=1

        val data = HashMap<String, String>()
        data["page"] = "1"



        val apiWeatherCall = mApiWeather!!.getUserList(data)
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */

        apiWeatherCall.enqueue(object : Callback<BaseUser> {

            override fun onResponse(call: Call<BaseUser>?, response: Response<BaseUser>?) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response?.body() != null) {
                    retrofitEventListener.onSuccess(call, response?.body())
                }
            }
            override fun onFailure(call: Call<BaseUser>?, t: Throwable?) {
                /*
                Error callback
                */
                retrofitEventListener.onError(call, t)
            }
        })

    }

}
