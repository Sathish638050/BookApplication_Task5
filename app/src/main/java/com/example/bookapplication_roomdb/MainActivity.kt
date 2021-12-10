package com.example.bookapplication_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication_roomdb.model.Author
import com.example.bookapplication_roomdb.model.Book
import com.example.bookapplication_roomdb.network.BookApplication
import com.example.bookapplication_roomdb.viewmodel.BookViewModel
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var myBookViewModel : BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        makeAPICall()

        val view = findViewById<RecyclerView>(R.id.resultData)
        val filterBtn = findViewById<Button>(R.id.filterBtn)
        val name = findViewById<TextInputLayout>(R.id.filterText)?.editText?.text
        val result = findViewById<TextView>(R.id.result)

        myBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        val adapter = MyViewAdapter()

        view.adapter = adapter
        view.layoutManager = LinearLayoutManager(applicationContext)

        filterBtn.setOnClickListener(){
            
            result.visibility = View.VISIBLE
            myBookViewModel.getBookByAuthor(name.toString()).observe(this,{
                book -> adapter.setData(book)
            })
        }
    }

    private fun makeAPICall(){
        val bookApplication = application as BookApplication
        val bookAppService = bookApplication.Books

        CoroutineScope(Dispatchers.IO).launch {
            val apiBook = bookAppService.getAllBook()
            withContext(Dispatchers.Main){
                for (data in apiBook){
                    val book = Book(0,data.title,data.author,data.language,data.year.toInt(),data.pages.toInt())
                    val author = Author(0,data.author,data.country)
                    myBookViewModel.insertAuthor(author)
                    myBookViewModel.insertBooks(book)
                }
            }
        }
    }
}
