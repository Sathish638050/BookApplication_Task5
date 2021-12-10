package com.example.bookapplication_roomdb.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bookapplication_roomdb.model.Author
import com.example.bookapplication_roomdb.model.Book

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAuthor(author: Author)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(book: Book)

    @Query("Select * from Books where author=:author limit 3")
    fun getFilterBook(author:String):LiveData<List<Book>>

    @Query("Select * from Books")
    fun getBooks():LiveData<List<Book>>
}