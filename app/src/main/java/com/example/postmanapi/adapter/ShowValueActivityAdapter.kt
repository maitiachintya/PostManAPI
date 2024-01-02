package com.example.postmanapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.postmanapi.R
import com.example.postmanapi.activity.ShowValueActivity
import com.example.postmanapi.model.Data

class ShowValueActivityAdapter(var context : ShowValueActivity, var showitemslists: List<Data>?)
    : RecyclerView.Adapter<ShowValueActivityAdapter.ShowValueViewHolder>(){

    class ShowValueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nametext = itemView.findViewById<TextView>(R.id.tvw_text)
        val textname = itemView.findViewById<TextView>(R.id.tvw_text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowValueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.childclass, parent, false)
        return ShowValueViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowValueViewHolder, position: Int) {
        holder.nametext.text = showitemslists?.get(position)?.api_name
        holder.textname.text = showitemslists?.get(position)?.company_name
    }

    override fun getItemCount(): Int {
        return showitemslists?.size!!
    }
}