package com.example.calender.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.calender.presentation.ui.component.Notes.NotesScreen
import com.example.calender.presentation.ui.component.firebaseNotes.FirestoreScreen
import com.example.calender.presentation.viewmodel.NoteViewModel
import com.example.calender.presentation.viewmodel.NotesFirebaseViewModel

@Composable
fun BottomNavGraph(navController: NavHostController){
    val noteViewModel:NoteViewModel = viewModel()
    val notesFirebaseViewModel:NotesFirebaseViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Personal.route){
        composable(route = BottomBarScreen.Personal.route){
            NotesScreen(noteViewModel)
        }
        composable(route = BottomBarScreen.Groups.route){
            FirestoreScreen(firebaseNotes = notesFirebaseViewModel.notesList,
                viewModel = notesFirebaseViewModel)
        }
    }
}