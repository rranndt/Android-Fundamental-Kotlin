package com.kotlin.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculateVolume: Button
    private lateinit var btnCalculateSurfaceArea: Button
    private lateinit var btnCalculateCircumference: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        edtWidth = findViewById(R.id.edtWidth)
        edtHeight = findViewById(R.id.edtHeight)
        edtLength = findViewById(R.id.edtLength)
        tvResult = findViewById(R.id.tvResult)
        btnCalculateVolume = findViewById(R.id.btnCalculateVolume)
        btnCalculateSurfaceArea = findViewById(R.id.btnCalculateSurfaceArea)
        btnCalculateCircumference = findViewById(R.id.btnCalculateCircumference)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            val length = edtLength.text.toString().trim()
            val width = edtWidth.text.toString().trim()
            val height = edtHeight.text.toString().trim()

            when {
                length.isEmpty() -> edtLength.error = getString(R.string.not_empty_field)
                width.isEmpty() -> edtWidth.error = getString(R.string.not_empty_field)
                height.isEmpty() -> edtHeight.error = getString(R.string.not_empty_field)
                else -> {
                    val l = length.toDouble()
                    val w = width.toDouble()
                    val h = height.toDouble()

                    when {
                        v.id == R.id.btnSave -> {
                            mainViewModel.save(l, w, h)
                            visible()
                        }
                        v.id == R.id.btnCalculateCircumference -> {
                            tvResult.text = mainViewModel.getrCircumference().toString()
                            gone()
                        }
                        v.id == R.id.btnCalculateSurfaceArea -> {
                            tvResult.text = mainViewModel.getSurfaceArea().toString()
                            gone()
                        }
                        v.id == R.id.btnCalculateVolume -> {
                            tvResult.text = mainViewModel.getVolume().toString()
                            gone()
                        }
                    }
                }
            }
        }
    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}