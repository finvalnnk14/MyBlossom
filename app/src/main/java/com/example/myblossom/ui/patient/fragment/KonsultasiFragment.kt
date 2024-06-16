package com.example.myblossom.ui.patient.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myblossom.ui.patient.PasienActivity
import com.example.myblossom.R
import com.example.myblossom.adapter.DokterAdapter
import com.example.myblossom.databinding.FragmentKonsultasiBinding
import com.example.myblossom.ui.patient.DaftarKonsultasi
import com.example.myblossom.viewmodel.UsersViewModel

class KonsultasiFragment : Fragment() {

    private lateinit var binding: FragmentKonsultasiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKonsultasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validateBtn2 = binding.validateBtn2

        validateBtn2.setOnClickListener {
            Toast.makeText(requireContext(), "sukses", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), PasienActivity::class.java)
            startActivity(intent)
        }

        // getting the recyclerview by its id
        val recycleruser = view.findViewById<RecyclerView>(R.id.recycleruser)

        // this creates a vertical layout Manager
        recycleruser.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<UsersViewModel>()
        data.add(UsersViewModel(R.drawable.profile, "Dokter Satu", "", ""))
        data.add(UsersViewModel(R.drawable.profile, "Dokter Dua", "", ""))

        // This will pass the ArrayList to our Adapter
        val DokterAdapter = DokterAdapter(data)

        // Setting the Adapter with the recyclerview
        recycleruser.adapter = DokterAdapter

        DokterAdapter.setOnClickListener(object : DokterAdapter.OnClickListener {
            override fun onClick(position: Int, model: UsersViewModel) {
                Toast.makeText(requireActivity(), "satu" + position, Toast.LENGTH_SHORT).show()
                val intent = Intent(requireActivity(), DaftarKonsultasi::class.java)
                requireActivity().startActivity(intent)
            }

            override fun onClick(p0: View?) {
                Toast.makeText(requireActivity(), "dua", Toast.LENGTH_SHORT).show()
            }
        })
    }
}