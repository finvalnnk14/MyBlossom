package com.example.myblossom.ui.patient.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myblossom.R
import com.example.myblossom.model.PredictRequest
import com.example.myblossom.viewmodel.PredictViewModel


const val BASE_URL = "http://34.101.154.16:8000/"

class HomeFragment : Fragment() {

    // private val progressBar: ProgressBar? = null
    // private val progressText: TextView? = null
    private val predictViewModel: PredictViewModel by viewModels()
    private lateinit var tanggalMulai: EditText
    private lateinit var panjangSiklus: EditText
    private lateinit var btnPredict: Button
    private lateinit var tvResult: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tanggalMulai = view.findViewById(R.id.etTanggalMulai)
        panjangSiklus = view.findViewById(R.id.etPanjangSiklus)
        btnPredict = view.findViewById(R.id.btnPredict)
        tvResult = view.findViewById(R.id.tvResult)

        btnPredict.setOnClickListener {
            val tanggalMulai = tanggalMulai.text.toString()
            val panjangSiklus = panjangSiklus.text.toString()
            val request =
                PredictRequest(startDate = tanggalMulai, cycleLength = panjangSiklus)
            predictViewModel.getPrediction(request)
        }

        predictViewModel.predictResponse.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { response ->
                tvResult.text = "${response.message}: ${response.data}"
            })
    }
}

/*

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
    // val progressBar = root.findViewById<ProgressBar>(R.id.progress_bar)
    // val progressText = root.findViewById<TextView>(R.id.progress_text)


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

/*
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

*/






    return root

    //return inflater.inflate(R.layout.fragment_home,container,false)
}

 */
