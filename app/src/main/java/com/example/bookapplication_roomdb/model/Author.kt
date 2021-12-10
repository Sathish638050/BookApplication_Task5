package com.example.bookapplication_roomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Authors")
class Author(
    @PrimaryKey(autoGenerate = true)
    val author_id :Int,
    val author: String,
    val country: String
)