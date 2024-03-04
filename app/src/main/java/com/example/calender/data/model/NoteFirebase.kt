package com.example.calender.data.model

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class NoteFirebase(
    var id: String? = null,
    var note:String? = null,
    var time: String? = null
){
    init {
        // Set the current time if not provided
        if (time.isNullOrEmpty()) {
            val currentTime = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.getDefault())
            time = dateFormat.format(currentTime)
        }
    }
}
