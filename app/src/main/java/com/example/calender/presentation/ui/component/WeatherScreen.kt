package com.example.calender.presentation.ui.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.calender.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel){
    val uiState by viewModel.uiState.observeAsState()
    uiState?.let { currentState ->
        when {
            currentState.isLoading -> {
                CircularProgressIndicator()
            }

            currentState.anyError -> {
                // Show error message
//                Text(text = currentState.errorMessage ?: "An error occurred.")
            }

            else -> {
                // Display weather information
                val currentWeather = currentState.currentWeatherForm
                if (currentWeather != null) {
                    Weather(
                        temp = currentWeather.temperature,
                        sunrise = currentWeather.sunrise,
                        sunset = currentWeather.sunset,
                        humidity = currentWeather.humidity,
                        description = currentWeather.description,
                        ic = currentWeather.icon
                    )
                } else {
                    // Handle null currentWeatherForm
                }
            }
        }
    }
}