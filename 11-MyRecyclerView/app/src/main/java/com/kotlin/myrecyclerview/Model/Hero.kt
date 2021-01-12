package com.kotlin.myrecyclerview.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Parcelize
data class Hero(

    var name: String,

    var description: String,

    var photo: String

) : Parcelable