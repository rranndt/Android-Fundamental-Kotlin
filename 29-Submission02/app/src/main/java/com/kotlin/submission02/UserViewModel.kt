package com.kotlin.submission02

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.submission02.model.user.User
import com.kotlin.submission02.network.Config
import retrofit2.Call
import retrofit2.Response

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class UserViewModel : ViewModel() {

    private val listUser: MutableLiveData<List<User>> = MutableLiveData()

    fun loadUser(context: Context?) {
        Config.getRetrofit().getUsers().enqueue(object : retrofit2.Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.body() != null) {
                    listUser.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    val getuserList: LiveData<List<User>> = listUser
}