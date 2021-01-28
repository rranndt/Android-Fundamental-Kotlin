package com.kotlin.myviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.myviewmodel.R
import com.kotlin.myviewmodel.databinding.WeatherItemsBinding
import com.kotlin.myviewmodel.model.WeatherItems

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val mData = ArrayList<WeatherItems>()

    fun setData(items: ArrayList<WeatherItems>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = WeatherItemsBinding.bind(itemView)
        fun bind(weatherItems: WeatherItems) {
            with(itemView) {
                binding.tvCity.text = weatherItems.name
                binding.tvTemp.text = weatherItems.temperature
                binding.tvDesc.text = weatherItems.description
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherAdapter.WeatherViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.weather_items, parent, false)
        return WeatherViewHolder(mView)
    }

    override fun onBindViewHolder(weatherViewHolder: WeatherAdapter.WeatherViewHolder, position: Int) {
        weatherViewHolder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size
}