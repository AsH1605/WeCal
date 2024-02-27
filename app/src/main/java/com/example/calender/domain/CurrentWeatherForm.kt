package com.example.calender.domain


data class CurrentWeatherForm(
    val name:String,
    val updatedDate: Int,
    val description:String,
    val temperature:String,
    val minTemperature:String,
    val maxTemperature:String,
    val sunrise:String,
    val sunset:String,
    val windSpeed:String,
    val pressure:String,
    val feelsLike:String,
    val humidity:String
)