package com.kotlin.myrecyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlin.myrecyclerview.ItemClickCallback
import com.kotlin.myrecyclerview.Model.Hero
import com.kotlin.myrecyclerview.databinding.ItemRowHeroBinding

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private var itemClickCallback: ItemClickCallback? = null

    fun setOnItemClickCallback(itemClickCallback: ItemClickCallback) {
        this.itemClickCallback = itemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHeroAdapter.ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class ListViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(ivPhoto)
                tvItemName.text = hero.name
                tvItemDesc.text = hero.description

                itemView.setOnClickListener {
                    itemClickCallback?.onItemClicked(hero)
                }
            }
        }
    }
}