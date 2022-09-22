package com.example.retrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.retrofit.models.MyToDo
import com.example.retrofit.retrofit.ApiClient
import com.example.retrofit.utils.Recourse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ToDoViewModel : ViewModel() {
    private val liveData = MutableLiveData<Recourse<List<MyToDo>>>()

    fun getAllToDo(): MutableLiveData<Recourse<List<MyToDo>>> {
        val apiService = ApiClient.apiService
        viewModelScope.launch {
            liveData.postValue(Recourse.loading("loading"))

            try {

                coroutineScope {
                    val list: List<MyToDo> = async {
                        apiService.getAllToDo()
                    }.await()

                    liveData.postValue(Recourse.success(list))
                }

            } catch (e: Exception) {
                liveData.postValue(Recourse.error(e.message))
            }
        }
        return liveData
    }
}