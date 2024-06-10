
package com.example.myblossom.model

data class PredictRequest(
    val tanggal_mulai: String,
    val panjang_siklus: String
)

data class PredictResponse(
    val message: String,
    val data: String
)