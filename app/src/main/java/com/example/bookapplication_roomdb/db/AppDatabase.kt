package com.example.bookapplication_roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookapplication_roomdb.model.Author
import com.example.bookapplication_roomdb.model.Book

@Database(entities = [Book::class,Author::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun BookDao():BooksDao

    companion object
    {
        @Volatile
        private var INSTANCE:AppDatabase?=null

        fun getDatabase(context: Context):AppDatabase{
            val TEMP_INSTANCE = INSTANCE
            if(TEMP_INSTANCE != null){
                return TEMP_INSTANCE
            }
            synchronized(this){
                val  instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,"BookApplication").build()
                INSTANCE = instance
                return instance
            }
        }
    }

}