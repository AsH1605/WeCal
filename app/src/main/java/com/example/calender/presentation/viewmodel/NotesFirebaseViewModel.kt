package com.example.calender.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.data.model.NoteFirebase
import com.example.calender.data.model.response.ResponseFromFirestore
import com.example.calender.domain.NotesFirebase.DeleteNoteResponse
import com.example.calender.domain.NotesFirebase.NotesResponse
import com.example.calender.domain.NotesFirebase.addNoteResponse
import com.example.calender.domain.UseCases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _notesList = mutableStateListOf<NoteFirebase>()
    val notesList: List<NoteFirebase> get() = _notesList

    init {
        fetchNotes()
    }

    private fun fetchNotes() = viewModelScope.launch {
        useCases.getNotes().collect { response ->
            NoteResponse = response
            if (response is ResponseFromFirestore.Success) {
                _notesList.clear()
                _notesList.addAll(response.data)
            }
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