package com.example.calender.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calender.data.db.NoteEntity
import com.example.calender.domain.Notes.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val notesRepository:NotesRepository
): ViewModel() {

    private val _note: MutableStateFlow<List<NoteEntity>> = MutableStateFlow(emptyList())
    val note = _note.asStateFlow()

    init {
        getNote()
    }

    private fun getNote(){
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.getNote().collect{data->
                _note.value = data
            }
        }
    }

    fun updateNOte(noteEntity: NoteEntity){
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.updateNote(noteEntity)
        }
    }

    fun deleteNote(noteEntity: NoteEntity){
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.deleteNote(noteEntity)
        }
    }

    fun addNote(noteEntity: NoteEntity){
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.addNote(noteEntity)
        }
    }
}