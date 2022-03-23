package com.example.challeng3.Fragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPerson(
    val name:String? = null,
    val result: Int? = null,
    val retiredAge: String? = null,
    val dieAge: String? = null,
    val outcome: String? = null
) : Parcelable
