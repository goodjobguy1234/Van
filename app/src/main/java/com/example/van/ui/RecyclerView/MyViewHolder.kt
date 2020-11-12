package com.example.van.ui.RecyclerView

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.forEach
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.van.R
import com.example.van.VanData
import com.google.common.io.Resources
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.viewhome.view.*

class MyViewHolder(itemView: View,val mcontext:Context) : RecyclerView.ViewHolder(itemView) {

    fun bind(item:VanData){
        itemView.price.text = item.price.toString()
        Glide.with(mcontext).load(item.pic)
            .into(itemView.imageView)

    }

    fun onclickRadio(position: Int){
        itemView.radioGroup.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton1){
                itemView.radioButton1.setTextColor(Color.parseColor("#023459"))
                itemView.radioButton2.setTextColor(Color.parseColor("#D1D3D4"))
            }else{
                itemView.radioButton1.setTextColor(Color.parseColor("#D1D3D4"))
                itemView.radioButton2.setTextColor(Color.parseColor("#023459"))
            }
        }
    }

    fun match(position:Int, item:ArrayList<Boolean>){

    }

}