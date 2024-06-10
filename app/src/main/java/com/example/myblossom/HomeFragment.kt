package com.example.myblossom

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.myblossom.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


const val BASE_URL = "http://34.101.154.16:8000/"

class HomeFragment : Fragment() {

    private val progressBar: ProgressBar? = null
    private val progressText: TextView? = null
    private lateinit var binding: FragmentHomeBinding


    // lateinit var laundriesRecycler: RecyclerView
    lateinit var billDateEditText: EditText


    var i = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
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