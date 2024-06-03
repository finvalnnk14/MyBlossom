package com.example.myblossom

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class HomeDokterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val root = inflater.inflate(R.layout.fragment_home_dokter, container, false)

        // getting the recyclerview by its id
        val recycleruser = root.findViewById<RecyclerView>(R.id.recycleruser)


        // this creates a vertical layout Manager
        recycleruser.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<UsersViewModel>()
        data.add(UsersViewModel(R.drawable.profile, "Pasien Satu", "", ""))
        data.add(UsersViewModel(R.drawable.profile, "Pasien Dua", "", ""))

        // This will pass the ArrayList to our Adapter
        val adapter = UserAdapter(data)

        // Setting the Adapter with the recyclerview
        recycleruser.adapter = adapter

        return root
    }
}