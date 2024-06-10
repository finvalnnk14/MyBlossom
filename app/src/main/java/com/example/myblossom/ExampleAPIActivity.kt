
package com.example.myblossom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myblossom.databinding.ActivityMainBinding
import com.example.myblossom.model.PredictRequest
import com.example.myblossom.viewmodel.PredictViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExampleAPIActivity : AppCompatActivity() {
    private val predictViewModel: PredictViewModel by viewModels()
    private lateinit var tanggalMulai: EditText
    private lateinit var panjangSiklus: EditText
    private lateinit var btnPredict: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_example_api)
        tanggalMulai = findViewById(R.id.etTanggalMulai)
        panjangSiklus = findViewById(R.id.etPanjangSiklus)
        btnPredict = findViewById(R.id.btnPredict)
        tvResult = findViewById(R.id.tvResult)

        btnPredict.setOnClickListener {
            val tanggalMulai = tanggalMulai.text.toString()
            val panjangSiklus = panjangSiklus.text.toString()
            val request = PredictRequest(tanggal_mulai = tanggalMulai, panjang_siklus = panjangSiklus)
            predictViewModel.getPrediction(request)
        }

        predictViewModel.predictResponse.observe(this, Observer { response ->
            tvResult.text = "${response.message}: ${response.data}"
        })
    }
}
                                    