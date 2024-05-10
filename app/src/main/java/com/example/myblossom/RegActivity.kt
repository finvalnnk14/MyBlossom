package com.example.myblossom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.util.Patterns
import com.example.myblossom.databinding.ActivityRegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class RegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = Firebase.auth

        binding.validateBtn.setOnClickListener {

            val email = binding.txtEmail1.text.toString()
            val password = binding.txtPassword1.text.toString()

            if(checkField()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password) .addOnCompleteListener {
                    if(it.isSuccessful) {
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

/*
class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtName1 = findViewById<TextInputEditText>(R.id.txtName1)
        val txtName2 = findViewById<TextInputLayout>(R.id.txtName2)




        txtName1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateName(txtName1, txtName2)
            }

        })


        val txtEmail1 = findViewById<TextInputEditText>(R.id.txtEmail1)
        val txtEmail2 = findViewById<TextInputLayout>(R.id.txtEmail2)

        txtEmail1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateEmail(txtEmail1, txtEmail2)
            }

        })


        val txtPassword1 = findViewById<TextInputEditText>(R.id.txtPassword1)
        val txtPassword2 = findViewById<TextInputLayout>(R.id.txtPassword2)

        txtPassword1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validatePassword(txtPassword1, txtPassword2)
            }

        })


        val txtConPassword1 = findViewById<TextInputEditText>(R.id.txtConPassword1)
        val txtConPassword2 = findViewById<TextInputLayout>(R.id.txtConPassword2)
        txtConPassword1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateConPassword(txtPassword1, txtConPassword1, txtConPassword2)
            }

        })


        val validateBtn = findViewById<Button>(R.id.validateBtn)
        validateBtn.setOnClickListener {
            if (validateName(txtName1, txtName2)
                && validateEmail(txtEmail1, txtEmail2)
                && validatePassword(txtPassword1, txtPassword2)
                && validateConPassword(txtPassword1, txtConPassword1, txtConPassword2)
            ) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                val intent = Intent(this@RegActivity, RegActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun validateConPassword(
        txtPassword1: TextInputEditText,
        txtConPassword1: TextInputEditText,
        txtConPassword2: TextInputLayout,
    ): Boolean {

        return when {
            txtConPassword1.text.toString().trim().isEmpty() -> {
                txtConPassword2.error = "Required"
                false
            }
            txtConPassword1.text.toString().trim().length < 8 || txtConPassword1.text.toString()
                .trim().length > 10 -> {
                txtConPassword2.error = "Password must be 8 to 10 Character!"
                false

            }
            txtPassword1.text.toString().trim() != txtConPassword1.text.toString().trim() -> {
                txtConPassword2.error = "Password Don't Match!"
                false
            }
            else -> {
                txtConPassword2.error = null
                true
            }
        }
    }

    private fun validatePassword(
        txtPassword1: TextInputEditText,
        txtPassword2: TextInputLayout,
    ): Boolean {
        return when {
            txtPassword1.text.toString().trim().isEmpty() -> {
                txtPassword2.error = "Required"
                false
            }
            txtPassword1.text.toString().trim().length < 8 || txtPassword1.text.toString()
                .trim().length > 10 -> {
                txtPassword2.error = "Password must be 8 to 10 Character!"
                false
            }
            else -> {
                txtPassword2.error = null
                true
            }
        }
    }

    private fun validateEmail(txtEmail1: TextInputEditText, txtEmail2: TextInputLayout): Boolean {
        val emailPattern = Regex("[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+")
        return when {
            txtEmail1.text.toString().trim().isEmpty() -> {
                txtEmail2.error = "Required"
                false
            }
            !txtEmail1.text.toString().trim().matches(emailPattern) -> {
                txtEmail2.error = "Valid E-mail"
                false
            }
            else -> {
                txtEmail2.error = null
                true
            }
        }
    }

    private fun validateName(txtName1: EditText, txtName2: TextInputLayout): Boolean {
        return when {
            txtName1.text.toString().trim().isEmpty() -> {
                txtName2.error = "Required"
                false
            }
            else -> {
                txtName2.error = null
                true
            }
        }
    }

 */
}