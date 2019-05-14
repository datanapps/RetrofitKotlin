package datanapps.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import datanapps.retrofitkotlin.R

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import datanapps.retrofitkotlin.services.network.RetrofitEventListener
import datanapps.retrofitkotlin.services.users.ApiUserRestClient
import datanapps.retrofitkotlin.services.users.model.BaseUser
import datanapps.retrofitkotlin.services.users.model.User
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callUserListData();
    }

    internal fun callUserListData() {

        ApiUserRestClient.instance.getUserList( object : RetrofitEventListener {
            override  fun onSuccess(call: Call<*>, response: Any) {
                if (response is BaseUser) {
                    Log.d("asd", "-----" + response.data!!.size)
                    setRecycleViewList(response.data!!);
                }
            }

            override fun onError(call: Call<*>, t: Throwable) {
                // snack bar that city can not find
            }
        })
    }

    private fun setRecycleViewList(userList: List<User>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_book)
        val mAdapter = UsersAdapter(this@MainActivity, userList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }
}
