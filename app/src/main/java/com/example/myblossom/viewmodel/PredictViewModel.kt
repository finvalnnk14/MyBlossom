
package com.example.myblossom.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myblossom.model.PredictRequest
import com.example.myblossom.model.PredictResponse
import com.example.myblossom.repository.PredictRepository
import kotlinx.coroutines.launch

class PredictViewModel : ViewModel() {
    private val repository = PredictRepository()

    private val _predictResponse = MutableLiveData<PredictResponse>()
    val predictResponse: LiveData<PredictResponse> get() = _predictResponse

    fun getPrediction(request: PredictRequest) {
        viewModelScope.launch {
            Log.e("Request data check", request.toString())
            val response = repository.getPrediction(request)
            _predictResponse.postValue(response)
        }
    }
}
                                    