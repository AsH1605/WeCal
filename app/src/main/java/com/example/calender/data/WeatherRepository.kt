package com.example.calender.data

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun fetchWeatherData(){
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .build().create(ApiInterface::class.java)

    val response = retrofit.getWeather("raipur", "888e702eccafe25282c560c0300be323", "metric")
    response.enqueue(object : Callback<WeatherApp>{
        override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
            val responseBody = response.body()
            if(response.isSuccessful && responseBody != null){
                val temperature = responseBody.main.temp.toString()
                Log.d("TAG", "onResponse: ${temperature}")
            }
        }

        override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}