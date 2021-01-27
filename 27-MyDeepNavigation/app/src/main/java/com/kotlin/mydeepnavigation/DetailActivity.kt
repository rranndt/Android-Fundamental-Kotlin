package com.kotlin.mydeepnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.mydeepnavigation.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_MESSAGE = "extra_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        binding.tvTitle.text = title
        binding.tvMessage.text = message
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}