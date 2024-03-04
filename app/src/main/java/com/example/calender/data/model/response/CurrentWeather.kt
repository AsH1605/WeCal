package com.example.calender.data.model.response

import com.example.calender.data.model.ApiResponse.Clouds
import com.example.calender.data.model.ApiResponse.Coord
import com.example.calender.data.model.ApiResponse.Main
import com.example.calender.data.model.ApiResponse.Sys
import com.example.calender.data.model.ApiResponse.Weather
import com.example.calender.data.model.ApiResponse.Wind
import com.google.gson.annotations.SerializedName


data class CurrentWeather(
    @SerializedName("base") val base: String,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("cod") val cod: Int,
    @SerializedName("coord") val coord: Coord,
    @SerializedName("dt") val dt: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: Main,
    @SerializedName("name") val name: String,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("wind") val wind: Wind
){
}