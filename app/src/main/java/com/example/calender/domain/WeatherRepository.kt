package com.example.calender.domain


import com.example.calender.data.WeatherRepositoryImpl
import com.example.calender.data.model.response.CurrentWeather
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherRepositoryImpl: WeatherRepositoryImpl){
    suspend fun fetchData(city: String): CurrentWeather {
        return weatherRepositoryImpl.getWeather(city)
    }
}