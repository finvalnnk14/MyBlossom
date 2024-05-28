package com.example.myblossom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class KonsultasiFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val root = inflater.inflate(R.layout.fragment_konsultasi, container, false)

        // getting the recyclerview by its id
        val recycleruser = root.findViewById<RecyclerView>(R.id.recycleruser)



        // this creates a vertical layout Manager
        recycleruser.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<UsersViewModel>()
        data.add(UsersViewModel(R.drawable.profile, "Dokter Satu", "",""))
        data.add(UsersViewModel(R.drawable.profile, "Dokter Dua", "",""))

        // This will pass the ArrayList to our Adapter
        val DokterAdapter = DokterAdapter(data)



        // Setting the Adapter with the recyclerview
        recycleruser.adapter = DokterAdapter


        DokterAdapter.setOnClickListener( object:
            DokterAdapter.OnClickListener {
            override fun onClick(position: Int, model: UsersViewModel) {
                Toast.makeText(requireActivity(), "satu" + position , Toast.LENGTH_SHORT).show();
//                val intent = Intent (requireActivity(), DaftarKonsultasi::class.java)
//                requireActivity().startActivity(intent)

            }

            override fun onClick(p0: View?) {
                Toast.makeText(requireActivity(), "dua", Toast.LENGTH_SHORT).show();
            }
        })

        return root
    }



}