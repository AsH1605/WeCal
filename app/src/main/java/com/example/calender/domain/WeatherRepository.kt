package com.example.calender.domain

import com.example.calender.data.WeatherRepositoryimpl
import com.example.calender.data.model.CurrentWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherRepositoryimpl: WeatherRepositoryimpl){
    fun fetchData(city: String): Flow<CurrentWeather> = flow {
        val response = weatherRepositoryimpl.fetchData(city)
        emit(response)
    }.flowOn(Dispatchers.IO).conflate()
}