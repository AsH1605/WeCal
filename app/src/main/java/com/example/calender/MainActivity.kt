package com.example.calender

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.calender.domain.WeatherRepository import com.example.calender.presentation.ui.component.Weather
import com.example.calender.presentation.viewmodel.WeatherViewModel
import com.example.calender.ui.theme.CalenderTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(FlowPreview::class)
    private val weatehrViewModel: WeatherViewModel by viewModels()

    @OptIn(FlowPreview::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BoxSet()
                }
            }
        }
        lifecycleScope.launch {
            weatehrViewModel.weatherResponse.collect { respond ->
                val temp = respond.main.temp.toString()
                val temp_max = respond.main.temp_max.toString()
                val temp_min = respond.main.temp_min.toString()
                val humidity = respond.main.humidity.toString()
                val pressure = respond.main.pressure.toString()
                Log.d("TAG", "temp: ${temp}")
//                Weather(temp = temp, temp_max = temp_max, temp_min = temp_min, pressure = pressure, humidity = humidity)
            }
        }
    }
}


@Composable
fun BoxSet(){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop
            )
        }
    }
}
