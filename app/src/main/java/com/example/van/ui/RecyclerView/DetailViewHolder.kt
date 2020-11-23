package com.example.van.ui.RecyclerView

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.van.TimeData
import kotlinx.android.synthetic.main.timetable.view.*

class DetailViewHolder(itemview:View): RecyclerView.ViewHolder(itemview) {
    fun bind(item:TimeData){
        itemView.textView.text = item.name
    }
    fun setColor(item:TimeData){
        val seatList = item.seat
        val size = seatList.size
        var count = 0
        seatList.forEach {
            if (!it){
                count++
            }
        }
        val card = itemView.card
        if (size == count){
            card.setCardBackgroundColor(Color.parseColor("#C0392B"))

        }else{
            card.setCardBackgroundColor(Color.parseColor("#14B344"))
        }
    }
}