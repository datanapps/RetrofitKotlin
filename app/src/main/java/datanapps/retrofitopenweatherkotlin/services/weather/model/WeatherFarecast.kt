package datanapps.retrofitopenweatherkotlin.services.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherFarecast {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Long? = null
    @SerializedName("list")
    @Expose
    var list: List<datanapps.retrofitopenweatherkotlin.services.weather.model.List<Any?>>? = null
    @SerializedName("city")
    @Expose
    var city: City? = null

}
