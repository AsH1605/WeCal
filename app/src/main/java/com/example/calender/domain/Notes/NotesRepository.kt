package com.example.calender.domain.Notes

import com.example.calender.data.db.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface NotesRepository{
    suspend fun getNote(): Flow<List<NoteEntity>>
    suspend fun addNote(note: NoteEntity)
    suspend fun updateNote(note: NoteEntity)
    suspend fun deleteNote(note: NoteEntity)
}