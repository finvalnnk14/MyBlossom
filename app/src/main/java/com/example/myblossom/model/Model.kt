
package com.example.myblossom.model

data class PredictRequest(
    val startDate: String,
    val cycleLength: String
)

data class PredictResponse(
    val message: String,
    val data: String
)