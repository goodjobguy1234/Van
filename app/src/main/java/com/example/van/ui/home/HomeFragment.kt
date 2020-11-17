package com.example.van.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.van.R
import com.example.van.VanData
import com.example.van.ui.RecyclerView.MyAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class HomeFragment() : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val db = FirebaseFirestore.getInstance()
    private val query:Query = db.collection("vandata")
    private lateinit var myAdapter: MyAdapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val options:FirestoreRecyclerOptions<VanData> = FirestoreRecyclerOptions.Builder<VanData>()
            .setQuery(query, VanData::class.java)
            .build()
        myAdapter = MyAdapter(options)
        recyclerView = view.findViewById(R.id.recycleViewer) as RecyclerView
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = myAdapter

        }

    }



    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()


    }

    override fun onStart() {
        super.onStart()
        myAdapter.startListening()

    }

}