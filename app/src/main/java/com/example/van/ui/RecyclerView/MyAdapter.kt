package com.example.van.ui.RecyclerView

import android.content.Context
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.van.R
import com.example.van.VanData
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query

class MyAdapter(options: FirestoreRecyclerOptions<VanData>): FirestoreRecyclerAdapter<VanData, MyViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewhome, parent,false)
        return MyViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: VanData) {
        holder.bind(model)
        holder.onclickRadio(position)
    }


}