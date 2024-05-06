package com.example.myblossom

import android.os.Bundle
//import android.support.v4.app.Fragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*

class ArticleFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val root = inflater.inflate(R.layout.fragment_article, container, false)

        // getting the recyclerview by its id
        val recyclerview = root.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        //for (i in 1..20) {
        //data.add(ItemsViewModel(R.drawable.mood2, "Item " + i))
        // }

        data.add(ItemsViewModel(R.drawable.arti1, ""))
        data.add(ItemsViewModel(R.drawable.arti2, ""))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
//        val root = inflater.inflate(R.layout.fragment_article, container, false)

//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "Virat Kohli", "Rohit Sharma", "Steve Smith",
//            "Kane Williamson", "Ross Taylor"
//        )
//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            R.drawable.mood2,
//            R.drawable.mood3
//        )

        // ArrayAdapter(this@ForecastActivity,android.R.layout.simple_list_item_1,forecasts)
        // access the listView from xml file
        //val progressBar = root.findViewById<ProgressBar>(R.id.progress_bar)
//        var mListView = root.findViewById<ListView>(R.id.articleList)

//       val imageView : ImageView = mListView.findViewById(R.id.modd)
        // var textView : TextView = mListView.findViewById(R.id.moddtxt)
        //var textView1 : TextView = view.findViewById(R.id.descTv)
        //arrayAdapter = ArrayAdapter(root.context, android.R.layout.simple_list_item_1, users)
        // arrayAdapter = ArrayAdapter(root.context, R.layout.article_list, users)
        // arrayAdapter = ArrayAdapter(root.context, R.layout.article_list, users)
//        mListView.adapter = arrayAdapter

        //articleList
        // val languages = listOf("Java", "Kotlin", "Javascript", "PHP", "Python")
        //return inflater.inflate(R.layout.fragment_article,container,false)
        return root
    }




}