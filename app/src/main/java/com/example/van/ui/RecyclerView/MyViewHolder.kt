package com.example.van.ui.RecyclerView

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.van.R
import com.example.van.VanData
import kotlinx.android.synthetic.main.viewhome.view.*


class MyViewHolder(itemView: View, val mcontext:Context, count:Int) : RecyclerView.ViewHolder(itemView) {


    companion object {
        const val TAG = "HomeFragment"
        const val PREF_ONE = "preferenceOne"
    }

    private val listOnePref: SharedPreferences = mcontext.getSharedPreferences(PREF_ONE, Context.MODE_PRIVATE)

    fun bind(item:VanData, position: Int){
        match(position)
        itemView.price.text = item.price.toString()
        Glide.with(mcontext).load(item.pic)
            .into(itemView.imageView)

    }

    fun onclickRadio(position: Int){
        itemView.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.radioButton1){
                itemView.radioButton1.setTextColor(Color.parseColor("#023459"))
                itemView.radioButton2.setTextColor(Color.parseColor("#D1D3D4"))
                listOnePref.edit().apply {
                    remove("list1_$position")
                    remove("list2_$position")
                    putBoolean("list1_$position", true)
                    putBoolean("list2_$position", false)
                    apply()
                }
            }
            else if (i == R.id.radioButton2){
                itemView.radioButton1.setTextColor(Color.parseColor("#D1D3D4"))
                itemView.radioButton2.setTextColor(Color.parseColor("#023459"))
                listOnePref.edit().apply {
                    remove("list1_$position")
                    remove("list2_$position")
                    putBoolean("list1_$position", false)
                    putBoolean("list2_$position", true)
                    apply()
                }
            }

        }


        }

    fun match(position:Int) {
        val firstRadio = listOnePref.getBoolean("list1_$position", false)
        val secondRadio = listOnePref.getBoolean("list2_$position", false)
        if (firstRadio && !secondRadio) {
            itemView.radioButton1.apply {
                setTextColor(Color.parseColor("#023459"))
                isChecked = true
            }

            itemView.radioButton2.apply {
                setTextColor(Color.parseColor("#D1D3D4"))
                isChecked = false
            }
        }
         else if (!firstRadio && secondRadio) {
            itemView.radioButton1.apply {
                setTextColor(Color.parseColor("#D1D3D4"))
                isChecked = false
            }
            itemView.radioButton2.apply {
                setTextColor(Color.parseColor("#023459"))
                isChecked = true
            }
        }
        else{
             itemView.radioButton1.apply {
                 setTextColor(Color.parseColor("#D1D3D4"))
                 isChecked = false
             }
             itemView.radioButton2.apply {
                 setTextColor(Color.parseColor("#D1D3D4"))
                 isChecked = false
             }
         }
    }

    fun clearData(){
        listOnePref.edit().apply {
            Log.d(TAG,"clearData: data is Clear")
            clear()
            apply()

        }
    }

    }
