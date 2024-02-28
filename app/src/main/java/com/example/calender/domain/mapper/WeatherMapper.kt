package com.example.calender.domain.mapper

import com.example.calender.R
import com.example.calender.data.WeatherUtils
import com.example.calender.data.model.response.CurrentWeather
import com.example.calender.domain.weather.CurrentWeatherForm
import javax.inject.Inject


class WeatherMapper @Inject constructor() {
    fun currentWeatherResponseToCurrentWeather(
        currentWeather: CurrentWeather
    ): CurrentWeatherForm {
        val icon=currentWeather.weather[0].icon
        val weatherIcon = mapIcon(icon)
        return CurrentWeatherForm(
            name = currentWeather.name,
            updatedDate = currentWeather.timezone,
            description = currentWeather.weather[0].description.uppercase(),
            temperature = WeatherUtils.getTemp(
                currentWeather.main.temp
            ),
            dt = WeatherUtils.getHourAndMinute(
                currentWeather.dt
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
            ),
            icon = weatherIcon
        )
    }

    private fun mapIcon(icon: String): Int {
        return when(icon){
            "01d"->R.drawable.d01
            "01n"->R.drawable.n01
            "02d"->R.drawable.d02
            "02n"-> R.drawable.n02
            "03d"->R.drawable.n03
            "03n"->R.drawable.n03
            "04d"->R.drawable.d04
            "04n"->R.drawable.n04
            "09d"->R.drawable.d09
            "09n"->R.drawable.n09
            "10d"->R.drawable.d10
            "10n"->R.drawable.n10
            "11d"->R.drawable.d11
            "11n"->R.drawable.n11
            "13d"->R.drawable.d13
            "13n"->R.drawable.n13
            "50d"->R.drawable.d50
            "50n"->R.drawable.n50
            else->R.drawable.d01
        }
    }
}