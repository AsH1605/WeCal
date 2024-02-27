package com.example.calender.domain

import com.example.calender.domain.mapper.WeatherMapper
import javax.inject.Inject

class CurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val weatherMapper: WeatherMapper
) {
    suspend operator fun invoke(): CurrentWeatherForm{
        return weatherMapper.currentWeatherResponseToCurrentWeather(
            currentWeather = weatherRepository.fetchData(city = "raipur")
        )
    }
}