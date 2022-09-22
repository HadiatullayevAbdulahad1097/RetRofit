package com.example.retrofit.repositorie

import com.example.retrofit.retrofit.ApiService

class ToDoRepository(val apiService: ApiService) {
    suspend fun getAllToDo() = apiService .getAllToDo()
}