package com.example.bookapplication_roomdb.network

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class BookApplication:Application() {
    public lateinit var Books:BookDataAPI

    override fun onCreate(){
        super.onCreate()
        Books = BookAppService()
    }

    private fun BookAppService():BookDataAPI{
        val retrofit = Retrofit.Builder().baseUrl("https://httpapibooks.mocklab.io/")
                    .addConverterFactory(JacksonConverterFactory.create(ObjectMapper())).build()
        return retrofit.create(BookDataAPI::class.java)
    }
}