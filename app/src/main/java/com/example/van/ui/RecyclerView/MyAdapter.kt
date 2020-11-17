package com.example.van.ui.RecyclerView


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.van.R
import com.example.van.VanData
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class MyAdapter(options: FirestoreRecyclerOptions<VanData>, mcontext:Context?): FirestoreRecyclerAdapter<VanData, MyViewHolder>(options) {

    lateinit var holder: MyViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewhome, parent,false)
        holder = MyViewHolder(view, parent.context, snapshots.count())
        Log.d("count", snapshots.count().toString())
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: VanData) {
        holder.apply {
            bind(model, layoutPosition)
            onclickRadio(layoutPosition)
        }
    }






}