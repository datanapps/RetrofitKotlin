package datanapps.retrofitkotlin.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import datanapps.retrofitkotlin.R
import datanapps.retrofitkotlin.services.users.model.User


class UsersAdapter(private val context: Context, private val userList: List<User>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_user, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.firstName +" "+ user.lastName
        holder.userEmail.text = user.email
          Glide.with(context)
                .load(user.avatar)
                .apply(RequestOptions().fitCenter())
                .into(holder.userIcon)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userName: TextView
         var userEmail: TextView
         var userIcon: ImageView

        init {
            userName = view.findViewById(R.id.layout_list_user_day_name)
            userEmail = view.findViewById(R.id.layout_list_user_email)
            userIcon = view.findViewById(R.id.layout_list_user_icon)

        }
    }

}