package com.example.calender.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity("notes")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo("note")
    val note:String,

    @ColumnInfo("done")
    val done: Boolean = false,

    @ColumnInfo("added")
    val added: Long = System.currentTimeMillis()
)

val NoteEntity.addDate: String get() = SimpleDateFormat("yyyy/MM/dd hh:mm").format(Date(added))