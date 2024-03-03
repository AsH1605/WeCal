package com.example.calender.domain.UseCases

data class UseCases (
    val getNotes: GetNote,
    val addNote: AddNote,
    val deleteNote: DeleteNote
)