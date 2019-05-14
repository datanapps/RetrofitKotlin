package datanapps.retrofitopenweatherkotlin.view

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import datanapps.retrofitopenweatherkotlin.R
import datanapps.retrofitopenweatherkotlin.services.users.User
import java.sql.Date
import java.text.SimpleDateFormat


class UsersAdapter(private val context: Context, private val userList: List<User>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_forecast, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.dayName.text = user.firstName
       /* holder.bookAuthor.text = book.authorName
        holder.publishedYear.text = book.publishedYear.toString()

        holder.dayName.text = getAgoDateTime(album.getDt() * 1000L)

        holder.tvMaxTemp.setText(album.getMain().getTempMax() + "\u2103")
        holder.tvMinTemp.setText(album.getMain().getTempMin() + "\u2103")

        holder.tvWeatherDetail.setText(album.getWeather().get(0).getDescription())

        Glide
                .with(context)
                .load(book.bookImage)
                .apply(RequestOptions().fitCenter())
                .into(holder.imageCover)*/

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun getAgoDateTime(pastTimeStamp: Long): String {

        var strDate = ""
        if (DateUtils.isToday(pastTimeStamp)) {

            strDate = "Today, " + SimpleDateFormat("hh:mm aa").format(Date(pastTimeStamp))
        } else if (DateUtils.isToday(pastTimeStamp + DateUtils.DAY_IN_MILLIS)) {
            strDate = "Yesterday, " + SimpleDateFormat("hh:mm aa").format(Date(pastTimeStamp))
        } else {

            strDate = SimpleDateFormat("EEEE, hh:mm aa").format(Date(pastTimeStamp))

        }


        return strDate
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dayName: TextView
         var tvMaxTemp: TextView
         var tvMinTemp: TextView
         var tvWeatherDetail: TextView
         var weatherIcon: ImageView

        init {
            dayName = view.findViewById(R.id.layout_list_forcast_day_name)
            tvMaxTemp = view.findViewById(R.id.layout_list_forcast_tv_max)
            tvMinTemp = view.findViewById(R.id.layout_list_forcast_tv_min)
            tvWeatherDetail = view.findViewById(R.id.layout_list_forcast_weather_detail)
            weatherIcon = view.findViewById(R.id.layout_list_forcast_weather_icon)

        }
    }

}