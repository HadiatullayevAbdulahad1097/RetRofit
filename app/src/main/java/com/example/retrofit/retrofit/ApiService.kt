package com.example.retrofit.retrofit

import com.example.retrofit.models.MyToDo
import retrofit2.http.GET

interface ApiService {

    @GET("plan")
    suspend fun getAllToDo() : List<MyToDo>
}