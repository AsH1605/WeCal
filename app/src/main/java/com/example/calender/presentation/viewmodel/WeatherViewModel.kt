package com.example.calender.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.domain.weather.CurrentWeatherUseCase
import com.example.calender.domain.Location.LocationTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val currentWeatherUseCase: CurrentWeatherUseCase
): ViewModel(){
    private val _uiState : MutableLiveData<CurrentWeatherViewState> = MutableLiveData()
    val uiState: LiveData<CurrentWeatherViewState>
        get() = _uiState


    fun getCurrentWeather() = viewModelScope.launch {
        try {
            _uiState.value = CurrentWeatherViewState(isLoading = true)
            val result = currentWeatherUseCase()
            _uiState.value = CurrentWeatherViewState(
                isLoading = false,
                currentWeatherForm = result
            )
//            Log.d("TAG", result.toString())
        } catch (e: Exception) {
            _uiState.value = CurrentWeatherViewState(
                anyError = true,
                errorMessage = e.message ?: "An error occurred.",
                isLoading = false
            )
        }
    }
}