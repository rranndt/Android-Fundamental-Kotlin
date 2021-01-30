package com.kotlin.submission02.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.submission02.R
import com.kotlin.submission02.databinding.LayoutItemUserBinding
import com.kotlin.submission02.model.user.User

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class UserAdapter(private val context: Context?, private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = LayoutItemUserBinding.bind(itemView)
        fun bind(userItems: User) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(userItems.avatarUrl)
                    .into(binding.ivAvatar)

                binding.tvUsername.text = userItems.login
                binding.tvHtmlUrl.text = userItems.htmlUrl
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_user, parent, false)
        return UserViewHolder(mView)
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        userViewHolder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}