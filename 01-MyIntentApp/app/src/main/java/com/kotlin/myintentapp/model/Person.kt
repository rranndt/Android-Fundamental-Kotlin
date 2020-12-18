package com.kotlin.myintentapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable
