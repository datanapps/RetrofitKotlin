package datanapps.retrofitopenweatherkotlin.services.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("3h")
    @Expose
    var h3:Double? = null

}
