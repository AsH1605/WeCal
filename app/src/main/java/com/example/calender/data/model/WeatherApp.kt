package com.example.calender.domain

import com.example.calender.domain.Clouds
import com.example.calender.domain.Coord
import com.example.calender.domain.Main
import com.example.calender.domain.Sys
import com.example.calender.domain.Weather
import com.example.calender.domain.Wind

data class WeatherApp(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)