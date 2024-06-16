package com.example.myblossom.ui


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myblossom.R
import com.example.myblossom.R.id.regBtn
import com.example.myblossom.ui.patient.RegActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mulaiBtn = findViewById<Button>(R.id.mulaiBtn)
        val regBtn = findViewById<Button>(regBtn)
        mulaiBtn.setOnClickListener {

            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)

        }


        regBtn.setOnClickListener {

            val intent = Intent(this@MainActivity, RegActivity::class.java)
            startActivity(intent)

        }

    }


}