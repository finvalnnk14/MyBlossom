package com.example.myblossom

import android.os.Bundle
//import android.support.v4.app.Fragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*

class ArticleFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val root = inflater.inflate(R.layout.fragment_article, container, false)

        // getting the recyclerview by its id
        val recyclerview = root.findViewById<RecyclerView>(R.id.recyclerview)



        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()
        data.add(ItemsViewModel(R.drawable.arti1, "", ""))
        data.add(ItemsViewModel(R.drawable.arti2, "", ""))
        data.add(ItemsViewModel(R.drawable.arti1, "", ""))
        data.add(ItemsViewModel(R.drawable.arti2, "", ""))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return root
    }




}