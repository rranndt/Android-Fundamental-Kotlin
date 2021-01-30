package com.kotlin.submission02.network

import com.kotlin.submission02.model.user.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
interface ApiService {

    @GET("users")
    @Headers("Authorization:21d777f4a6e63f0e19684460f5a9de90cc031f3f")
    fun getUsers(
    ) : Call<List<User>>

}