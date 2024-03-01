package com.example.calender.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    fun addNote(note: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getNote() : Flow<List<NoteEntity>>

    @Update
    fun updateNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)
}