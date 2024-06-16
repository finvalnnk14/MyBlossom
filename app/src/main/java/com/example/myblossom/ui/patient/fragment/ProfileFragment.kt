package com.example.myblossom.ui.patient.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myblossom.R
import com.example.myblossom.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        tvName = view.findViewById(R.id.tv_name)
        tvEmail = view.findViewById(R.id.tv_email)
        btnLogout = view.findViewById(R.id.btnLogout)

        firebaseAuth = FirebaseAuth.getInstance()
        firestore = Firebase.firestore

        btnLogout.setOnClickListener {
            logout()
        }

        loadUserData()

        return view
    }

    private fun loadUserData() {
        val currentUser = firebaseAuth.currentUser
        currentUser?.let { user ->
            val userId = user.uid
            val usersRef = firestore.collection("users").document(userId)

            usersRef.get().addOnSuccessListener { document ->
                if (document.exists()) {
                    val name = document.getString("name")
                    val email = document.getString("email")
                    tvName.text = name
                    tvEmail.text = email
                } else {
                    Toast.makeText(requireContext(), "User data not found", Toast.LENGTH_SHORT)
                        .show()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(
                    requireContext(),
                    "Error getting user data: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(requireContext(), "Logged out successfully!", Toast.LENGTH_SHORT).show()

        val moveToLoginActivity = Intent(requireContext(), MainActivity::class.java)
        startActivity(moveToLoginActivity)

        activity?.finish()
    }
}