package com.example.calender.data

import com.example.calender.data.model.CurrentWeather
import com.example.calender.domain.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@AndroidEntryPoint
class WeatherRepositoryimpl @Inject constructor(
    private val apiInterface: ApiInterface
){
    suspend fun fetchData(city: String): CurrentWeather {
        return apiInterface.getWeather(city = city)
    }
}