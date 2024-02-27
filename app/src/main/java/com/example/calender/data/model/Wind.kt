package com.example.calender.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wind(
    val deg: Int = 0,
    val speed: Double = 0.0
) : Parcelable