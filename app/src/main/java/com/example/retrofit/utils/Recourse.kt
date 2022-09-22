package com.example.retrofit.utils

data class Recourse <out T>(val status: Status, val data: T?, val message: String?){

    companion object{
        fun <T>success(data:T):Recourse<T>{
            return Recourse(Status.SUCCESS, data,  null)
        }
        fun <T>error(message: String?):Recourse<T>{
            return Recourse(Status.ERROR,null, message)
        }
        fun <T>loading(message: String?):Recourse<T>{
            return Recourse(Status.LOADING, null, message)
        }
    }
}