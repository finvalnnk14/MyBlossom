package com.example.myblossom.ui.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import android.widget.Toast
import com.example.myblossom.R
import com.example.myblossom.ui.doctor.DashboardDokterActivity


class DaftarKonsultasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar_konsultasi)

        val validateBtn2 = findViewById<Button>(R.id.validateBtn2)
        validateBtn2.setOnClickListener {
            Toast.makeText(this@DaftarKonsultasi, "sukses", Toast.LENGTH_SHORT).show();
            val intent = Intent(this@DaftarKonsultasi, DashboardDokterActivity::class.java)
            startActivity(intent)


        }





    }



}