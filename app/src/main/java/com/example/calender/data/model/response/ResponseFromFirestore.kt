package com.example.calender.data.model.response


sealed class ResponseFromFirestore<out T> {
    object Loading: ResponseFromFirestore<Nothing>()

    data class Success<out T>(
        val data: T
    ): ResponseFromFirestore<T>()

    data class Failure(
        val e: Exception?
    ): ResponseFromFirestore<Nothing>()
}