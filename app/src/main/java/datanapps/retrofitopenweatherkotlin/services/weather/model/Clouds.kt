package datanapps.retrofitopenweatherkotlin.services.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {

    @SerializedName("all")
    @Expose
    var all: Long? = null

}
