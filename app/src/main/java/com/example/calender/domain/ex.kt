package com.example.calender.domain

import android.util.Log
import com.example.calender.data.ApiInterface
import com.example.calender.data.model.WeatherApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun fetchWeatherData(city: String){
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .build().create(ApiInterface::class.java)

    val response = retrofit.getWeather(city, "888e702eccafe25282c560c0300be323", "metric")
    response.enqueue(object : Callback<WeatherApp>{
        override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
            val responseBody = response.body()
            if(response.isSuccessful && responseBody != null){
                val temperature = responseBody.main.temp.toString()
                val time = responseBody.timezone.toString()
                val max_temp = responseBody.main.temp_max.toString()
                val min_temp = responseBody.main.temp_min.toString()
                val pressure = responseBody.main.pressure.toString()
                val humidity = responseBody.main.humidity.toString()
            }
        }

        override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
            Log.d("TAG", "cannot fetch data")
        }
    })
}