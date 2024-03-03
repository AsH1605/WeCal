package com.example.calender.domain.UseCases

import com.example.calender.domain.NotesFirebase.NotesFirebaseRepository

class AddNote(
    private val repo: NotesFirebaseRepository
) {
    suspend operator fun invoke(
        note: String
    ) = repo.addNoteToFirestore(note)
}