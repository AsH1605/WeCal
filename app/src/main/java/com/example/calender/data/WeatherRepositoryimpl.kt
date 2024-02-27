package com.example.calender.data

import com.example.calender.data.model.response.CurrentWeather
import com.example.calender.data.remote.ApiInterface
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) {
    suspend fun getWeather(city: String): CurrentWeather {
        return apiInterface.getWeather(city)
    }
}