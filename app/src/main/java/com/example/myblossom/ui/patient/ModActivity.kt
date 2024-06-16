package com.example.myblossom.ui.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import com.example.myblossom.R


class ModActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mod)

        val validateBtn2 = findViewById<Button>(R.id.validateBtn2)
        validateBtn2.setOnClickListener {
            val intent = Intent(this@ModActivity, DashboardActivity::class.java)
            startActivity(intent)

        }


    }


}