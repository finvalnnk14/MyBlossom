package com.example.myblossom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




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





        val validateBtn = findViewById<Button>(R.id.validateBtn)
        validateBtn.setOnClickListener {
            if (validateEmail(txtEmail1, txtEmail2)
                && validatePassword(txtPassword1, txtPassword2)
            ) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
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
}