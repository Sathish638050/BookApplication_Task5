package com.example.bookapplication_roomdb.network

import com.example.bookapplication_roomdb.model.APIData
import retrofit2.http.GET

interface BookDataAPI {
    @GET("books")
    suspend fun getAllBook():List<APIData>
}