package com.example.bookapplication_roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bookapplication_roomdb.db.AppDatabase
import com.example.bookapplication_roomdb.model.Author
import com.example.bookapplication_roomdb.model.Book
import com.example.bookapplication_roomdb.network.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application):AndroidViewModel(application) {
    private val bookRepo : BookRepository
    val AllData : LiveData<List<Book>>
    init {
        val BookDao = AppDatabase.getDatabase(application).BookDao()
        bookRepo = BookRepository(BookDao)
        AllData = BookDao.getBooks()
    }

    fun getBookByAuthor(author: String):    LiveData<List<Book>>{
        return bookRepo.getBookByAuthor(author)
    }

    fun insertBooks(book : Book){
        viewModelScope.launch(Dispatchers.IO){
            bookRepo.insertBook(book)
        }
    }

    fun insertAuthor(author: Author){
        viewModelScope.launch(Dispatchers.IO){
            bookRepo.insertAuthor(author)
        }
    }

}