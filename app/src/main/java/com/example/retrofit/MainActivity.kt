package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.ViewModel.ToDoViewModel
import com.example.retrofit.adapter.MyToDoAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.utils.Status

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toDoViewModel: ToDoViewModel
    lateinit var myToDoAdapter: MyToDoAdapter
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)

        myToDoAdapter = MyToDoAdapter()

        binding.rv.adapter = myToDoAdapter

        toDoViewModel.getAllToDo()
            .observe(this) {
                when(it.status){
                    Status.LOADING -> Log.d(TAG, "onCreate: Loading")
                    Status.ERROR -> Log.d(TAG, "onCreate: Error ${it.message}")
                    Status.SUCCESS ->{
                        myToDoAdapter.list = it.data!!
                        myToDoAdapter.notifyDataSetChanged()
                        Log.d(TAG, "onCreate: ${it.data}")
                    }
                }
            }
    }
}