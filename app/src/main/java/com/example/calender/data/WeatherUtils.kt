package com.example.calender.data

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object WeatherUtils {

    fun getHourAndMinute(timestamp: Int): String {
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        calendar.timeInMillis = timestamp * 1000L
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return "${hour}:${minute}"
    }


    fun getTemp(temp: Double): String {
        val formattedTemp = String.format("%.2f", temp - 273)
        return "$formattedTemp °C"
    }


    fun getMinTemp(temp: Double): String {
        return "Min temp: $temp °C"
    }


    fun getMaxTemp(temp: Double): String {
        return "Max temp: $temp °C"
    }

    fun getWindSpeed(speed: Double): String {
        return "$speed m/s"
    }

    fun getPressure(pressure: Int): String {
        return "$pressure hPa"
    }

    fun getHumidity(pressure: Int): String {
        return "$pressure %"
    }
}