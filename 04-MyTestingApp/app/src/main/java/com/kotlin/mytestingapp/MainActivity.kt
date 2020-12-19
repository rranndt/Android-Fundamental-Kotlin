package com.kotlin.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView
    private lateinit var ivPreview: ImageView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        btnSetValue = findViewById(R.id.btnSetValue)
        btnSetValue.setOnClickListener(this)
        ivPreview = findViewById(R.id.ivPreview)

        /*
        Error OutOfMemoryException
        ivPreview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fronalpstock_big))
        */
        Glide.with(this)
                .load(R.drawable.fronalpstock_big)
                .into(ivPreview)

        names.add("Narenda Wicaksono")
        names.add("Kevin")
        names.add("Yoza")
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btnSetValue) {
                Log.d("MainActivity", names.toString())
                val name = StringBuilder()
                for (i in 0..2) {
                    name.append(names[i]).append("\n")
                }
                tvText.text = name.toString()
            }
        }
    }
}