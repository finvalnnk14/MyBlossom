package com.example.myblossom


//import android.content.Intent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
//import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

//import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

//import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        title = resources.getString(R.string.home)
        loadFragment(HomeFragment())

        bottomNav = findViewById(R.id.navigationView)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.articleFragment -> {
                    title = resources.getString(R.string.article)
                    loadFragment(ArticleFragment())
                    true
                }
                R.id.konsultasiFragment -> {
                    title = resources.getString(R.string.konsultasi)
                    loadFragment(KonsultasiFragment())
                    true
                }
                R.id.profileFragment -> {
                    title = resources.getString(R.string.profile)
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
