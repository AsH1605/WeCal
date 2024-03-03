package com.example.calender.data.di

import com.example.calender.data.RepositoryImpl.NoteFromFirebaseRepositoryImpl
import com.example.calender.domain.NotesFirebase.NotesFirebaseRepository
import com.example.calender.domain.UseCases.AddNote
import com.example.calender.domain.UseCases.DeleteNote
import com.example.calender.domain.UseCases.GetNote
import com.example.calender.domain.UseCases.UseCases
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    fun provideNoteRef() = Firebase.firestore.collection("Notes")

    @Provides
    fun provideBooksRepository(
        noteRef: CollectionReference
    ): NotesFirebaseRepository = NoteFromFirebaseRepositoryImpl(noteRef)

    @Provides
    fun provideUseCases(
        repo: NotesFirebaseRepository
    ) = UseCases(
        getNotes = GetNote(repo),
        addNote = AddNote(repo),
        deleteNote = DeleteNote(repo)
    )
}