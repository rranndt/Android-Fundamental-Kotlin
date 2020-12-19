package com.kotlin.submission1.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kotlin.submission1.databinding.ActivityDetailBinding
import com.kotlin.submission1.model.User

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val BUNDLE = "bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(BUNDLE)
        binding.tvUsername.text = user?.name
        binding.tvDescription.text = user?.description
        Glide.with(this)
            .load(user?.photo)
            .into(binding.ivAvatar)

        supportActionBar?.setTitle(user?.name)
    }
}