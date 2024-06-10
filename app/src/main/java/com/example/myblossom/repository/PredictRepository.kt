
package com.example.myblossom.repository

import com.example.myblossom.model.PredictRequest
import com.example.myblossom.model.PredictResponse
import com.example.myblossom.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PredictRepository {
    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://34.101.154.16:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    suspend fun getPrediction(request: PredictRequest): PredictResponse {
        return apiService.getPrediction(request.tanggal_mulai, request.panjang_siklus.toInt())
    }
}
                                    