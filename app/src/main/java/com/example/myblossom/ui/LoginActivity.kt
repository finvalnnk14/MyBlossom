package com.example.myblossom.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.myblossom.ui.patient.ModActivity
import com.example.myblossom.databinding.ActivityLoginBinding
import com.example.myblossom.ui.doctor.DashboardDokterActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.auth
import okhttp3.*
import java.io.IOException
import org.json.JSONObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var client: OkHttpClient
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        client = OkHttpClient()
        firebaseAuth = Firebase.auth

        binding.validateBtn.setOnClickListener {
            val email = binding.txtEmail1.text.toString()
            val password = binding.txtPassword1.text.toString()

            if (checkField()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val moveToRegisterActivity =
                            Intent(this@LoginActivity, ModActivity::class.java)
                        startActivity(moveToRegisterActivity)
                    } else {
                        if (it.exception is FirebaseAuthInvalidUserException || it.exception is FirebaseAuthInvalidCredentialsException) {
                            logindokter(email, password)
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Username or Password is not correct",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun checkField(): Boolean {
        val email = binding.txtEmail1.text.toString()
        val password = binding.txtPassword1.text.toString()

        if (email.isEmpty()) {
            binding.txtEmail2.error = "This field must be filled"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.txtEmail2.error = "Email format is not valid"
            return false
        }
        if (password.isEmpty()) {
            binding.txtPassword2.error = "This field must be filled"
            return false
        }
        if (password.length <= 6) {
            binding.txtPassword2.error = "Password should be at least 6 characters"
            return false
        }
        return true
    }

    private fun logindokter(email: String, password: String) {
        val urlLogin = "https://finavalentina.vercel.app/user/login"

        // Create a JSON object with email and password fields
        val jsonBody = JSONObject().apply {
            put("email", email)
            put("password", password)
        }

        // Create a request body with JSON media type
        val requestBody = jsonBody.toString().toRequestBody("application/json".toMediaType())

        val requestLogin = Request.Builder()
            .url(urlLogin)
            .post(requestBody)
            .build()

        client.newCall(requestLogin).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(
                        this@LoginActivity,
                        "Failed to connect to server",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                runOnUiThread {
                    val jsonResponse = JSONObject(responseBody ?: "{}")
                    val message = jsonResponse.optString("message", "")
                    if (message == "Login successful") {
                        Toast.makeText(this@LoginActivity, "Login successful", Toast.LENGTH_SHORT)
                            .show()
                        // Navigate to DashboardActivity
                        val intent = Intent(this@LoginActivity, DashboardDokterActivity::class.java)
                        startActivity(intent)
                        finish() // Close LoginActivity
                    } else {
                        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
