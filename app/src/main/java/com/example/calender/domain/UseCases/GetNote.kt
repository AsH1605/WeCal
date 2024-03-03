package com.example.calender.domain.UseCases

import com.example.calender.domain.NotesFirebase.NotesFirebaseRepository

class GetNote(
    private val repo:NotesFirebaseRepository
) {
    operator fun invoke() = repo.getNotesFromFirestore()
}