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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calender.domain.CurrentWeatherUseCase
import com.example.calender.domain.WeatherRepository import com.example.calender.presentation.ui.component.Weather
import com.example.calender.presentation.viewmodel.WeatherViewModel
import com.example.calender.ui.theme.CalenderTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var weatherRepository: WeatherRepository
    private val viewModel: WeatherViewModel by viewModels()
//    private val binding by viewBinding(FragmentCurrentWeatherBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    BoxSet()
//                    WeatherScreen()
                }
            }
        }
        viewModel.getCurrentWeather()
    }
}

//@OptIn(FlowPreview::class)
//@Composable
//fun WeatherScreen(weatherViewModel: WeatherViewModel = viewModel()) {
//    val weatherResponse by weatherViewModel.weatherResponse.collectAsState(initial = null)
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        if (weatherResponse != null) {
//            val response = weatherResponse!!
////            ImageLoader(response.weather[0].description)
////            Text(text = response.weather[0].description)
//            Text(text = response.name)
//            Text(text = response.wind.deg.toString())
//            Text(text = response.wind.speed.toString())
//            Text(text = ((((response.main.temp?.minus(273))?.times(100.0))?.toInt() )?.div(100.0)).toString())
//            Text(text = response.main.humidity.toString())
//        } else {
//            Text(text = "Loading...")
//        }
//    }
//}


//@Composable
//fun BoxSet(){
//    Column {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.bg),
//                modifier = Modifier.fillMaxSize(),
//                contentDescription = "Background Image",
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}}
