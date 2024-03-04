package com.example.calender.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.data.model.response.ResponseFromFirestore
import com.example.calender.domain.NotesFirebase.DeleteNoteResponse
import com.example.calender.domain.NotesFirebase.NotesResponse
import com.example.calender.domain.NotesFirebase.addNoteResponse
import com.example.calender.domain.UseCases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesFirebaseViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel(){
    var NoteResponse by mutableStateOf<NotesResponse>(ResponseFromFirestore.Loading)
        private set

    var addNoteRes by mutableStateOf<addNoteResponse>(ResponseFromFirestore.Success(false))
        private set

    var deleteNoteResponse by mutableStateOf<DeleteNoteResponse>(ResponseFromFirestore.Success(false))
        private set

    init {
        getNote()
    }

    private fun getNote() = viewModelScope.launch {
        useCases.getNotes().collect{response->
            NoteResponse = response
        }
    }

    fun addNote(note: String) = viewModelScope.launch {
        addNoteRes = ResponseFromFirestore.Loading
        addNoteRes = useCases.addNote(note)
    }

    fun deleteNotek(id: String) = viewModelScope.launch {
        deleteNoteResponse = ResponseFromFirestore.Loading
        deleteNoteResponse = useCases.deleteNote(id)
    }
}