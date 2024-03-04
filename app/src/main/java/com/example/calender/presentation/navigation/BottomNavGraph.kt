package com.example.calender.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.calender.presentation.ui.component.Notes.NotesScreen
import com.example.calender.presentation.ui.component.firebaseNotes.FirestoreScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBar.Personal.route){
        composable(route = BottomBarGraph.Personal.route){
            NotesScreen()
        }
        composable(route = BottomBarScreen.Groups.route){
            FirestoreScreen(firebaseNotes = emptyList())
        }
    }
}