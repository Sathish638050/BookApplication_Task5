package com.example.bookapplication_roomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val book_id : Int,
    val title : String,
    val author : String,
    val language : String,
    val year : Int,
    val pages : Int
)