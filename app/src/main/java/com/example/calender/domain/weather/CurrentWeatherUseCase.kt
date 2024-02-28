package com.example.calender.domain.weather

import android.util.Log
import com.example.calender.domain.Location.LocationTracker
import com.example.calender.domain.mapper.WeatherMapper
import javax.inject.Inject

class CurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val weatherMapper: WeatherMapper,
    private val locationTracker: LocationTracker
) {
    suspend operator fun invoke(): CurrentWeatherForm {
        locationTracker.getCurrentLocation()?.let { location ->
            Log.d("TAG","${location.latitude} && ${location.longitude}")
            return weatherMapper.currentWeatherResponseToCurrentWeather(
                currentWeather = weatherRepository.fetchData(location.latitude,location.longitude)
            )
        }?: kotlin.run {
            Log.d("TAG","error fetching location")
        }
        return weatherMapper.currentWeatherResponseToCurrentWeather(
            currentWeather = weatherRepository.fetchData(21.2514,81.6296)
        )
    }
}