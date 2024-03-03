package com.example.calender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.calender.domain.weather.WeatherRepository
import com.example.calender.presentation.ui.component.Notes.NotesScreen
import com.example.calender.presentation.ui.component.Weather.WeatherScreen
import com.example.calender.presentation.ui.component.firebaseNotes.FirebaseNotesScreen
import com.example.calender.presentation.viewmodel.WeatherViewModel
import com.example.calender.ui.theme.CalenderTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var weatherRepository: WeatherRepository
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BoxSet()
                    Column {
                        WeatherScreen(viewModel)
                        Spacer(modifier = Modifier.height(8.dp))
//                        NotesScreen()
//                        Spacer(modifier = Modifier.height(8.dp))
                        FirebaseNotesScreen(firebaseNotes = emptyList())
                    }
                }
            }
        }
        viewModel.getCurrentWeather()
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
