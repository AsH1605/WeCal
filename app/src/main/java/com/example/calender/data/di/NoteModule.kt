package com.example.calender.data.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calender.data.NotesRepositoryImpl
import com.example.calender.data.db.NoteDatabase
import com.example.calender.domain.Notes.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase):NotesRepository{
        return NotesRepositoryImpl(db)
    }
}