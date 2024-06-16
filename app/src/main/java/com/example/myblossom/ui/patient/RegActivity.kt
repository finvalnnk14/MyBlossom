package com.example.myblossom.ui.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.util.Patterns
import com.example.myblossom.R
import com.example.myblossom.databinding.ActivityRegisterBinding
import com.example.myblossom.ui.MainActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore


@Suppress("DEPRECATION")
class RegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = Firebase.auth
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        binding.validateBtn.setOnClickListener {

            val email = binding.txtEmail1.text.toString()
            val password = binding.txtPassword1.text.toString()
            val name = binding.txtName1.text.toString()

            if(checkField()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password) .addOnCompleteListener {
                    if(it.isSuccessful) {
                        val user = auth.currentUser
                        user?.let {
                            storeUserData(it.uid, name, email)
                        }
                        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT) .show()
                        val moveToMainActivity = Intent(this@RegActivity, MainActivity::class.java)
                        startActivity(moveToMainActivity)
                    }
                    else {
                        Log.e("Error: ", it.exception.toString())
                    }
                }
            }
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun storeUserData(id: String, name: String, email: String) {
        val userData = hashMapOf(
            "id" to id,
            "name" to name,
            "email" to email,
        )
        db.collection("users").document(id)
            .set(userData)
            .addOnSuccessListener {
                Toast.makeText(baseContext, "User data stored successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(baseContext, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkField(): Boolean {

        val email = binding.txtEmail1.text.toString()
        val password = binding.txtPassword1.text.toString()
        val confirmpassword = binding.txtConPassword1.text.toString()

        if(email.isEmpty()) {
            binding.txtEmail2.error = "This field must be filled"
            return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.txtEmail2.error = "Email format is not valid"
            return false
        }
        if(password.isEmpty()) {
            binding.txtPassword2.error = "This field must be filled"
            return false
        }
        if(binding.txtPassword1.length() <= 6) {
            binding.txtPassword2.error = "Password should be at least 6 characters"
            return false
        }
        if(confirmpassword.isEmpty()) {
            binding.txtConPassword2.error = "This field must be filled"
            return false
        }
        if(password != confirmpassword) {
            binding.txtConPassword2.error = "Password does not match"
            return false
        }
        return true
    }
}