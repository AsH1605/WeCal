package com.example.calender.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.data.model.CurrentWeather
import com.example.calender.data.model.Main
import com.example.calender.data.model.Wind
import com.example.calender.domain.WeatherRepository
import com.example.calender.presentation.ui.component.Weather
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



@OptIn(ExperimentalCoroutinesApi::class)
@FlowPreview
@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel(){
    private val _weatherResponse: MutableStateFlow<CurrentWeather> = MutableStateFlow(
        CurrentWeather(
            Main(),
            "Today's update",
            listOf(com.example.calender.data.model.Weather()),
            Wind()
        )
    )
    private val searchChannel = MutableSharedFlow<String>(1)
    val weatherResponse: StateFlow<CurrentWeather> = _weatherResponse

    fun setSearchQuery(search: String) {
        searchChannel.tryEmit(search)
    }

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            searchChannel.flatMapLatest {
                weatherRepository.fetchData("raipur")
            }.catch { e->
                Log.d("main", "${e.message}... error is in viewmodel")
            }.collect{response->
                _weatherResponse.value = response
            }
        }
    }
}