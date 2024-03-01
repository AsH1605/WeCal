package com.example.calender.data

import com.example.calender.data.db.NoteDatabase
import com.example.calender.data.db.NoteEntity
import com.example.calender.domain.Notes.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(private val database: NoteDatabase):NotesRepository {
    private val dao = database.noteDao()
    override suspend fun addNote(note: NoteEntity) {
        dao.addNote(note)
    }

    override suspend fun getNote(): Flow<List<NoteEntity>> =
        dao.getNote()

    override suspend fun updateNote(note: NoteEntity) {
        dao.updateNote(note)
    }

    override suspend fun deleteNote(note: NoteEntity) {
        dao.deleteNote(note)
    }


}