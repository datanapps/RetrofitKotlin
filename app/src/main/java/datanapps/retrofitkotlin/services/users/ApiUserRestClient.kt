package datanapps.retrofitkotlin.services.users

import java.util.HashMap

import datanapps.retrofitkotlin.services.network.NetworkClient
import datanapps.retrofitkotlin.services.network.RetrofitEventListener
import datanapps.retrofitkotlin.services.users.model.BaseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiUserRestClient {

    companion object {
        val instance = ApiUserRestClient()
    }

    private var mApiUser: APIUser? = null

    /**
     * Invoke getUserList via [Call] request.
     * @param retrofitEventListener of RetrofitEventListener.
     */

    //     https://reqres.in/api/users?page=1
    fun getUserList(retrofitEventListener: RetrofitEventListener) {
        val retrofit = NetworkClient.retrofitClient
        mApiUser = retrofit.create<APIUser>(APIUser::class.java)

        val data = HashMap<String, String>()
        data["page"] = "1"

        val apiUserCall = mApiUser!!.getUserList(data)
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */

        apiUserCall.enqueue(object : Callback<BaseUser> {

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
