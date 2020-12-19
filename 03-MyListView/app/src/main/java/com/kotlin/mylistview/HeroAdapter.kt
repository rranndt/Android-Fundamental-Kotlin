package com.kotlin.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kotlin.mylistview.model.Hero
import de.hdodenhof.circleimageview.CircleImageView

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var heroes = arrayListOf<Hero>()

    override fun getCount(): Int {
        return heroes.size
    }

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val tvName: TextView = view.findViewById(R.id.tvName)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        private val ivPhoto: CircleImageView = view.findViewById(R.id.ivPhoto)

        fun bind(hero: Hero) {
            tvName.text = hero.name
            tvDescription.text = hero.description
            ivPhoto.setImageResource(hero.photo)
        }
    }

}