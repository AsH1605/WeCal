package com.example.calender.data.model.ApiResponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
) : Parcelable