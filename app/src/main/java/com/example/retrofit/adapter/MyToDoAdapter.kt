package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemRvBinding
import com.example.retrofit.models.MyToDo

class MyToDoAdapter(var list: List<MyToDo> = emptyList()) : RecyclerView.Adapter<MyToDoAdapter.Vh>() {
    inner class Vh(val itemRv:ItemRvBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(myToDo: MyToDo){
            itemRv.tv1.text = myToDo.sarlavha
            itemRv.tv2.text = myToDo.matn
            itemRv.tv3.text = myToDo.holat
            itemRv.tv4.text = myToDo.oxirgi_muddat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}