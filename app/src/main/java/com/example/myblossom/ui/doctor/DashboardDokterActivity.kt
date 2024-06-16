package com.example.myblossom.ui.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myblossom.ui.patient.fragment.ProfileFragment
import com.example.myblossom.R
import com.example.myblossom.ui.doctor.fragment.HomeDokterFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardDokterActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_dokter)

        title = resources.getString(R.string.home)
        loadFragmentx(HomeDokterFragment())
//navigationView

        bottomNav = findViewById(R.id.navigationView) as BottomNavigationView

        bottomNav.setOnItemSelectedListener {
            //NavigationBarView.OnItemSelectedListener {
            when (it.itemId) {
                R.id.homeDokterFragment -> {
                    loadFragmentx(HomeDokterFragment())

                }


                R.id.profileFragment -> {
                    title = resources.getString(R.string.profile)
                    loadFragmentx(ProfileFragment())

                }


            }
            true
        }


    }


    private fun loadFragmentx(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerx, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}