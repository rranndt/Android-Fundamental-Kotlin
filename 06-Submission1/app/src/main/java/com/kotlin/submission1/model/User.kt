package com.kotlin.submission1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Parcelize
data class User(
    var photo: Int? = 0,
    var name: String? = "",
    var description: String? = ""
) : Parcelable
