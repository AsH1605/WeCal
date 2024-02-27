package com.example.calender.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.data.model.response.CurrentWeather
import com.example.calender.data.model.Main
import com.example.calender.data.model.Wind
import com.example.calender.domain.CurrentWeatherUseCase
import com.example.calender.domain.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
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
            Log.d("TAG", result.toString())
        } catch (e: Exception) {
            _uiState.value = CurrentWeatherViewState(
                anyError = true,
                errorMessage = e.message ?: "An error occurred.",
                isLoading = false
            )
        }
    }
}