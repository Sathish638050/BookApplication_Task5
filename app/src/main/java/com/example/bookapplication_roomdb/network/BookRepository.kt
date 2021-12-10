package com.example.bookapplication_roomdb.network

import androidx.lifecycle.LiveData
import com.example.bookapplication_roomdb.db.BooksDao
import com.example.bookapplication_roomdb.model.Author
import com.example.bookapplication_roomdb.model.Book

class BookRepository(private val BooksDao : BooksDao) {

    val AllData:LiveData<List<Book>> = BooksDao.getBooks()

    fun getBookByAuthor(author: String):LiveData<List<Book>>{
        return BooksDao.getFilterBook(author)
    }

    fun insertBook(book: Book){
        BooksDao.insertBook(book)
    }

    fun insertAuthor(author: Author){
        BooksDao.insertAuthor(author)
    }
}