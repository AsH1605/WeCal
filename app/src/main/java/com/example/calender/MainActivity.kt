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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calender.data.model.NoteFirebase
import com.example.calender.data.model.response.ResponseFromFirestore
import com.example.calender.domain.weather.WeatherRepository
import com.example.calender.presentation.navigation.BottomBarScreen
import com.example.calender.presentation.navigation.BottomNavGraph
import com.example.calender.presentation.ui.component.Notes.NotesScreen
import com.example.calender.presentation.ui.component.Weather.WeatherScreen
import com.example.calender.presentation.ui.component.firebaseNotes.FirestoreScreen
import com.example.calender.presentation.viewmodel.NotesFirebaseViewModel
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    BoxSet()
                    Column {
                        WeatherScreen(viewModel)
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomBottomAppBar(navController = navController)
                        BottomNavGraph(navController = navController)
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

@Composable
fun CustomBottomAppBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val list = listOf(
        BottomBarScreen.Personal,
        BottomBarScreen.Groups
    )
    var selectedIndex by remember { mutableStateOf(list.indexOfFirst { it.route == currentRoute }) }
    NavigationBar{
        list.forEachIndexed { index, screens->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screens.route)
                    selectedIndex = index
                },
                icon = {
                    Icon(
                        imageVector = screens.icon,
                        contentDescription = screens.title,
                        tint = if (selectedIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = screens.title,
                        color = if (selectedIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}
