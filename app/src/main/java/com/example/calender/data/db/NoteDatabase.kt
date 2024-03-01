package com.example.calender.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NotesDao

    companion object{
        const val DATABASE_NAME="notes_db"
    }
}