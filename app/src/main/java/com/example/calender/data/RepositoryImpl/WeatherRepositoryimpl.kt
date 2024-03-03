package com.example.calender.data.RepositoryImpl

import com.example.calender.data.model.response.CurrentWeather
import com.example.calender.data.remote.ApiInterface
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) {
    suspend fun getWeather(lat: Double, lon: Double): CurrentWeather {
        return apiInterface.getWeather(lat, lon)
    }
}