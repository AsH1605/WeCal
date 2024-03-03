package com.example.calender.domain.NotesFirebase

import com.example.calender.data.model.response.NoteFirebase
import com.example.calender.data.model.response.ResponseFromFirestore
import kotlinx.coroutines.flow.Flow

typealias Notes = List<NoteFirebase>
typealias NotesResponse = ResponseFromFirestore<Notes>
typealias addNoteResponse = ResponseFromFirestore<Boolean>
typealias DeleteNoteResponse = ResponseFromFirestore<Boolean>

interface NotesFirebaseRepository {
    fun getNotesFromFirestore(): Flow<NotesResponse>

    suspend fun addNoteToFirestore(note: String): addNoteResponse

    suspend fun deleteNoteFromFirebase(id: String): DeleteNoteResponse
}