package com.example.calender.domain.mapper

import com.example.calender.data.WeatherUtils
import com.example.calender.data.model.response.CurrentWeather
import com.example.calender.domain.CurrentWeatherForm
import javax.inject.Inject


class WeatherMapper @Inject constructor() {
    fun currentWeatherResponseToCurrentWeather(
        currentWeather: CurrentWeather
    ):CurrentWeatherForm{
        return CurrentWeatherForm(
            name = currentWeather.name,
            updatedDate = currentWeather.timezone,
            description = currentWeather.weather[0].description,
            temperature = WeatherUtils.getTemp(
                currentWeather.main.temp
            ),
            maxTemperature = WeatherUtils.getMaxTemp(
                currentWeather.main.temp_max
            ),
            minTemperature = WeatherUtils.getMinTemp(
                currentWeather.main.temp_min
            ),
            sunrise = WeatherUtils.getHourAndMinute(
                currentWeather.sys.sunrise
            ),
            sunset = WeatherUtils.getHourAndMinute(
                currentWeather.sys.sunset
            ),
            windSpeed = WeatherUtils.getWindSpeed(
                currentWeather.wind.speed
            ),
            pressure = WeatherUtils.getPressure(
                currentWeather.main.pressure
            ),
            feelsLike = currentWeather.main.feels_like.toString(),
            humidity = WeatherUtils.getHumidity(
                currentWeather.main.humidity
            )
        )
    }
}