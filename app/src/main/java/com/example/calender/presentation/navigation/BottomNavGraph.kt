package com.example.calender.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.calender.presentation.ui.component.Notes.NotesScreen
import com.example.calender.presentation.ui.component.firebaseNotes.FirestoreScreen
import com.example.calender.presentation.viewmodel.NoteViewModel

@Composable
fun BottomNavGraph(navController: NavHostController){
    val noteViewModel:NoteViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Personal.route){
        composable(route = BottomBarScreen.Personal.route){
            NotesScreen(noteViewModel)
        }
        composable(route = BottomBarScreen.Groups.route){
            FirestoreScreen(firebaseNotes = emptyList())
        }
    }
}