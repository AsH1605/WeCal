package com.example.calender.data.remote

import com.example.calender.data.model.response.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid:String = "0e52bb63e84036aa2e3be5c9858c1d15",
//        @Query("units") units:String = "metric"
    ): CurrentWeather

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
    }
}