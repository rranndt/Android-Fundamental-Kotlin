package com.kotlin.submission1.ui.home

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.submission1.ui.detail.DetailActivity
import com.kotlin.submission1.R
import com.kotlin.submission1.adapter.UserAdapter
import com.kotlin.submission1.databinding.ActivityMainBinding
import com.kotlin.submission1.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Home")

        adapter = UserAdapter(this)
        binding.lvList.adapter = adapter

        prepare()
        addItem()

        binding.lvList.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val userDetail = User()
                userDetail.photo = dataPhoto.getResourceId(i, -1)
                userDetail.name = dataName[i]
                userDetail.description = dataDescription[i]

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.BUNDLE, userDetail)
                startActivity(intent)
                Toast.makeText(this@MainActivity, users[i].name, Toast.LENGTH_SHORT).show()
            }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            users.add(user)
        }
        adapter.user = users
    }
}