package datanapps.retrofitkotlin.services.users

import datanapps.retrofitkotlin.services.users.model.BaseUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * API for getting weather from https://darksky.net/
 */
interface APIUser {

    @GET("api/users?")
    fun getUserList(@QueryMap options: Map<String, String>): Call<BaseUser>
}
