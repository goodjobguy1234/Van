package com.example.van.ui.RecyclerView


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.van.R
import com.example.van.VanData
import com.example.van.ui.home.HomeFragment
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.viewhome.view.*


class MyAdapter(options: FirestoreRecyclerOptions<VanData>): FirestoreRecyclerAdapter<VanData, HomeViewHolder>(options) {

    lateinit var holder: HomeViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewhome, parent,false)
        holder = HomeViewHolder(view, parent.context)
        return holder
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int, model: VanData) {
        holder.apply {
            bind(model, layoutPosition)
            onclickRadio(layoutPosition)
            itemView.setOnClickListener(HomeFragment())
//            itemView.next_btn.setOnClickListener(this@MyAdapter)
        }
    }




}