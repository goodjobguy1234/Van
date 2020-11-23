package com.example.van.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.van.R
import com.example.van.TimeData
import com.example.van.VanData
import com.example.van.ui.RecyclerView.TimetableAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment_detail.*
import java.text.DateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "type"
private const val ARG_PARAM2 = "name"
private const val ARG_PARAM3 = "phone"
private const val ARG_PARAM4 = "pic_url"
/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var type: String? = null
    private var name: String? = null
    private var phone: String? = null
    private var pic_url: String? = null
    private val db = FirebaseFirestore.getInstance()
    private val ref = db.collection("timetable")
    lateinit var madapter:TimetableAdapter
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString(ARG_PARAM1)
            name = it.getString(ARG_PARAM2)
            phone = it.getString(ARG_PARAM3)
            pic_url = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phone_txt.text = phone
        var fullname = createName(name)
        var collectionType:String = ""
        when(type){
            "goes" ->{
                fullname_txt.text = "$fullname to Assumption University"
                collectionType = "goes"
            }
            "back" -> {
                fullname_txt.text = "Assumption University to $fullname"
                collectionType = "back"
            }
        }
        Glide.with(this).load(pic_url).circleCrop().into(imageProfile)
        val calendar = Calendar.getInstance()
        val currentDate =  DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
        day_txt.text = currentDate
        val query = ref.document(fullname).collection(collectionType) as Query
        Log.d("query", query.toString())
        val options: FirestoreRecyclerOptions<TimeData> = FirestoreRecyclerOptions.Builder<TimeData>()
            .setQuery(query, TimeData::class.java)
            .build()
        madapter = TimetableAdapter(options)
        val recyclerView = view.findViewById(R.id.grid_recycle) as RecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = madapter
        }

    }

    private fun createName(name: String?):String {
        var returnName:String = "Unknown"
        when(name){
            "Fn" -> returnName = "FasionIsland"
            "Mn" -> returnName = "Megabangna"
        }
        return returnName

    }

    override fun onStop() {
        super.onStop()
        madapter.stopListening()


    }

    override fun onStart() {
        super.onStart()
        madapter.startListening()

    }




//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment DetailFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            DetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}