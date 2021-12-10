package com.example.bookapplication_roomdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication_roomdb.model.Book

class MyViewAdapter: RecyclerView.Adapter<MyViewAdapter.MyViewHolder>() {
    var listData = emptyList<Book>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.booklist_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewAdapter.MyViewHolder, position: Int) {
        val current = listData[position]
        holder.itemView.findViewById<TextView>(R.id.titleName).text = current.title
        holder.itemView.findViewById<TextView>(R.id.bookYear).text = current.year.toString()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setData(books:List<Book>){
        this.listData =books
        notifyDataSetChanged()
    }
}