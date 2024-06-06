package com.example.myblossom

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment


class HomeFragment : Fragment(){

    private val progressBar: ProgressBar? = null
    private val progressText: TextView? = null
   // lateinit var laundriesRecycler: RecyclerView
    var i = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //laundriesRecycler = root.findViewById(R.id.fragment_home)
        //progressBar = findViewById(R.layout.progress_bar);
        //progressText = findViewById(R.id.progress_text);
        val progressBar = root.findViewById<ProgressBar>(R.id.progress_bar)
        val progressText = root.findViewById<TextView>(R.id.progress_text)
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                // set the limitations for the numeric
                // text under the progress bar
                if (i <= 100) {
                    //progressText.setText("" + i)
                    progressText.text="" + i
                    progressBar.progress = i
                    i++
                    handler.postDelayed(this, 200)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        }, 200)

        return root

        //return inflater.inflate(R.layout.fragment_home,container,false)
    }
}