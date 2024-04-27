package com.example.myblossom


//import android.content.Intent
import android.os.Bundle
import android.widget.Toast
//import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

//import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

//import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        title=resources.getString(R.string.home)
        loadFragment(HomeFragment())
//navigationView

        bottomNav = findViewById(R.id.navigationView) as BottomNavigationView

        bottomNav.setOnItemSelectedListener{
            //NavigationBarView.OnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment-> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.articleFragment-> {
                    title=resources.getString(R.string.article)
                    loadFragment(ArticleFragment())
                    true
                }

                R.id.konsultasiFragment-> {
                    title=resources.getString(R.string.article)
                    loadFragment(KonsultasiFragment())
                    true
                }

                R.id.profileFragment-> {
                    title=resources.getString(R.string.article)
                    loadFragment(ProfileFragment())
                    true
                }


            }
            true
        }







    }


    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }











}