package com.example.calender.domain.UseCases

import com.example.calender.domain.NotesFirebase.NotesFirebaseRepository

class DeleteNote(
    private val repo: NotesFirebaseRepository
) {
    suspend operator fun invoke(id: String) = repo.deleteNoteFromFirebase(id)
}