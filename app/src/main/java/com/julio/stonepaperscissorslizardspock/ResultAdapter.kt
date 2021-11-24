package com.julio.stonepaperscissorslizardspock

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter (private val context : Context, private val listResults : List<String>) : RecyclerView.Adapter<ResultAdapter.MyViewHolder>()  {

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.textView_result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_result, parent, false)
        return MyViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val item = listResults[position]
        holder.textView.text = item

    }

    override fun getItemCount() = listResults.size


}