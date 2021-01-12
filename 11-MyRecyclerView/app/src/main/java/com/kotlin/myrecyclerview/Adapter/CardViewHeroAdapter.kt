package com.kotlin.myrecyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlin.myrecyclerview.Model.Hero
import com.kotlin.myrecyclerview.databinding.ItemCardviewHeroBinding

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemCardviewHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    class CardViewViewHolder(private val binding: ItemCardviewHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions.overrideOf(350, 350))
                    .into(ivPhoto)
                tvItemName.text = hero.name
                tvItemDescription.text = hero.description

                btnSetFavorite.setOnClickListener {
                    Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT)
                        .show()
                }

                btnSetShare.setOnClickListener {
                    Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT)
                        .show()
                }

                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Kamu memilih ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}