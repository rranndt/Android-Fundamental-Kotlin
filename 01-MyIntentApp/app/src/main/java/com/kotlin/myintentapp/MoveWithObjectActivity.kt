package com.kotlin.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kotlin.myintentapp.model.Person

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObjectReceived: TextView = findViewById(R.id.tvObjectReceived)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name: ${person.name.toString()}, " +
                "\nEmail: ${person.email}, " +
                "\nAge: ${person.age}," +
                "\nLocation: ${person.city}"
        tvObjectReceived.text = text
    }
}