package com.example.myblossom.ui.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myblossom.R
import com.example.myblossom.databinding.ActivityRegister3Binding

class RegActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityRegister3Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)
        binding = ActivityRegister3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val validateBtn2 = findViewById<Button>(R.id.validateBtn2)
        validateBtn2.setOnClickListener {
            val intent = Intent(this@RegActivity3, RegActivity3::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}