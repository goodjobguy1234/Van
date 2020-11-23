package com.example.van.ui.RecyclerView

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.van.R
import com.example.van.TimeData
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.timetable.view.*

class TimetableAdapter(options:FirestoreRecyclerOptions<TimeData>):FirestoreRecyclerAdapter<TimeData,DetailViewHolder>(options) {
    lateinit var holder: DetailViewHolder
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timetable, parent,false)
        holder = DetailViewHolder(view)
        context = parent.context
       return holder
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int, model: TimeData) {
        holder.apply {
            bind(model)
            setColor(model)
            itemView.card.setOnClickListener {
                if (it.card.cardBackgroundColor.defaultColor == Color.parseColor("#14B344")){
                    Log.d("isOkayToclick", "yes")
                    val navController = itemView.findNavController()
                    navController.navigate(R.id.seatSelectFragment)
                }else{
                    Log.d("isOkayToclick", "No")
                    val toast = Toast.makeText(context, "All seat have already booked", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }


    }


}