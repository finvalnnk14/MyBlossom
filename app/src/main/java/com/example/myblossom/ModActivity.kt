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