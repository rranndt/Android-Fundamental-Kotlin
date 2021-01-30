package com.kotlin.submission02.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Parcelize
class User(

    @field:SerializedName("login")
    val login: String,

    @field:SerializedName("avatar_url")
    val avatarUrl: String,

    @field:SerializedName("html_url")
    val htmlUrl: String,

    @field:SerializedName("id")
    val id: Int

) : Parcelable