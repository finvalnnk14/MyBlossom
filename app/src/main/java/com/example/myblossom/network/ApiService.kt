
package com.example.myblossom.network

import com.example.myblossom.model.PredictRequest
import com.example.myblossom.model.PredictResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/predict")
    suspend fun getPrediction(@Query("tanggal_mulai") startDate:String,
                              @Query("panjang_siklus") cycleLength:Number, ): PredictResponse
}
                                    