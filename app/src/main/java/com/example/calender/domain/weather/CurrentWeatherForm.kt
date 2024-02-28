package com.example.calender.domain.weather


data class CurrentWeatherForm(
    val name:String,
    val updatedDate: Int,
    val description:String,
    val temperature:String,
    val dt:String,
    val minTemperature:String,
    val maxTemperature:String,
    val sunrise:String,
    val sunset:String,
    val windSpeed:String,
    val pressure:String,
    val feelsLike:String,
    val humidity:String,
    val icon: Int
)