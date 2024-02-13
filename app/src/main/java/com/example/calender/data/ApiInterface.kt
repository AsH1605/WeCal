package com.example.calender.data

import com.example.calender.data.model.CurrentWeather
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city:String,
        @Query("appid") appid:String = "888e702eccafe25282c560c0300be323",
        @Query("units") units:String = "metric"
    ): CurrentWeather

    companion object {
        const val BASE_URL = "https://api.yourweatherapi.com/"
    }
}