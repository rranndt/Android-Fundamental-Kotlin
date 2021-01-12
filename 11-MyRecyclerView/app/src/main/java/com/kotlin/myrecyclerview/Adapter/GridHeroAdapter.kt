package com.kotlin.myrecyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlin.myrecyclerview.ItemClickCallback
import com.kotlin.myrecyclerview.Model.Hero
import com.kotlin.myrecyclerview.databinding.ItemGridHeroBinding

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class GridHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private var itemClickCallback: ItemClickCallback? = null

    fun setOnItemClickCallback(itemClickCallback: ItemClickCallback) {
        this.itemClickCallback = itemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridHeroAdapter.GridViewHolder {
        val binding =
            ItemGridHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class GridViewHolder(private val binding: ItemGridHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions.overrideOf(350, 350))
                    .into(ivPhoto)

                itemView.setOnClickListener {
                    itemClickCallback?.onItemClicked(hero)
                }
            }
        }
    }
}