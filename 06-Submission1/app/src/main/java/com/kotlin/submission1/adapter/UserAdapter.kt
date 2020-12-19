package com.kotlin.submission1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.kotlin.submission1.R
import com.kotlin.submission1.databinding.ItemUserBinding
import com.kotlin.submission1.model.User

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class UserAdapter internal constructor(private val mContext: Context) : BaseAdapter() {

    internal var user = arrayListOf<User>()

    override fun getCount(): Int {
        return user.size
    }

    override fun getItem(i: Int): Any {
        return user[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val binding = ItemUserBinding.bind(view)
        internal fun bind(user: User) {
            binding.tvUsername.setText(user.name)
            Glide.with(view.context)
                .load(user.photo)
                .into(binding.ivAvatar)
        }
    }
}