package com.example.calender.data.model

data class CurrentWeather(
//    val base: String? = "",
//    val clouds: Clouds? = null,
//    val cod: Int?= 0,
//    val coord: Coord?= null,
//    val dt: Long?= 0L,
//    val id: Int?= 0,
    val main: Main,
    val name: String = "",
//    val sys: Sys?= null,
//    val timeZone: Int?= null,
//    val visibility: Int?=0,
    val weatherItems: List<Weather>,
    val wind: Wind
){
}
