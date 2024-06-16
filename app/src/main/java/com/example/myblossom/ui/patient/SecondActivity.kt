package com.example.myblossom.ui.patient

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import android.widget.NumberPicker
import com.example.myblossom.R


class SecondActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val numpicker1 = findViewById<NumberPicker>(R.id.numpicker1)
        numpicker1.minValue=0
        numpicker1.maxValue=30
        numpicker1.value=15

        val validateBtn2 = findViewById<Button>(R.id.validateBtn2)
        validateBtn2.setOnClickListener {

            val intent = Intent(this@SecondActivity, ModActivity::class.java)
            startActivity(intent)

        }



    }



}