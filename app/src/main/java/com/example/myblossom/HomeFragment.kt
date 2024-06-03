package com.example.myblossom

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {

    private val progressBar: ProgressBar? = null
    private val progressText: TextView? = null


    // lateinit var laundriesRecycler: RecyclerView
    lateinit var billDateEditText: EditText


    var i = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //laundriesRecycler = root.findViewById(R.id.fragment_home)
        //progressBar = findViewById(R.layout.progress_bar);
        //progressText = findViewById(R.id.progress_text);
        val progressBar = root.findViewById<ProgressBar>(R.id.progress_bar)
        val progressText = root.findViewById<TextView>(R.id.progress_text)


        //val billDateEditText = root.findViewById<EditText>(R.id.editText_date)

        //showDatePicker()


//                R.id.validateBtn2 -> {
//                    Toast.makeText(getContext(), "Signed Out.", Toast.LENGTH_SHORT).show()
//
//                    val intent = Intent(activity, PasienActivity::class.java)
//                    startActivity(intent)
//                }

//        val validateBtn2 = root.findViewById<Button>(R.id.validateBtn2)
//        validateBtn2.setOnClickListener {
//            Toast.makeText(getContext(), "Signed Out.", Toast.LENGTH_SHORT).show()
//            val intent = Intent(getActivity(), PasienActivity::class.java)
//            getActivity()?.startActivity(intent)
//
//
//
//
//        }


        val handler = Handler()
        handler.postDelayed(object : Runnable {


            override fun run() {
                // set the limitations for the numeric
                // text under the progress bar
                if (i <= 100) {
                    //progressText.setText("" + i)
                    progressText.text = "" + i
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