package com.example.calender.domain.Location

import android.location.Location


interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}