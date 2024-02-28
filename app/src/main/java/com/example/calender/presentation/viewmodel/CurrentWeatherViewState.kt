package com.example.calender.presentation.viewmodel

import com.example.calender.domain.weather.CurrentWeatherForm

data class CurrentWeatherViewState (
    val currentWeatherForm: CurrentWeatherForm?=null,
    val isLoading:Boolean,
    val anyError:Boolean=false,
    val errorMessage:String?=null
)