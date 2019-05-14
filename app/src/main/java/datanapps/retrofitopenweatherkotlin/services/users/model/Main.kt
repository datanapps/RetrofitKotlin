package datanapps.retrofitopenweatherkotlin.services.users.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    @Expose
    var temp: Double? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Double? = null
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Long? = null
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double? = null

}
