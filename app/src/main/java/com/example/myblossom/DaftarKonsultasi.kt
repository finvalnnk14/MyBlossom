package com.example.myblossom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


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