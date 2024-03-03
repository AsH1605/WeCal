package com.example.calender.domain.weather


import com.example.calender.data.RepositoryImpl.WeatherRepositoryImpl
import com.example.calender.data.model.response.CurrentWeather
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherRepositoryImpl: WeatherRepositoryImpl){
    suspend fun fetchData(lat: Double, lon: Double): CurrentWeather {
        return weatherRepositoryImpl.getWeather(lat, lon)
    }
}