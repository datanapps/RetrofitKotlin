package datanapps.retrofitopenweatherkotlin.view

import androidx.appcompat.app.AppCompatActivity
import datanapps.retrofitopenweatherkotlin.R

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import datanapps.retrofitopenweatherkotlin.services.network.RetrofitEventListener
import datanapps.retrofitopenweatherkotlin.services.weather.ApiWeatherRestClient
import datanapps.retrofitopenweatherkotlin.services.weather.model.WeatherFarecast
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleViewList()
    }


    private fun setRecycleViewList() {
       /* val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_book)
        val mAdapter = BooksAdapter(this@MainActivity, bookList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter*/
    }


    internal fun uploadWeatherData() {
        //showProgressDialog("Wait...");
        ApiWeatherRestClient.instance.getWeather(title.toString(), object : RetrofitEventListener {
            override  fun onSuccess(call: Call<*>, response: Any) {
                if (response is WeatherFarecast) {
                    Log.d("asd", "-----" + response.list)
                   // weatherAdapter.setAlbumList((response as WeatherFarecast).list)
                }
            }

            override fun onError(call: Call<*>, t: Throwable) {

                // snack bar that city can not find
            }
        })
    }
}
