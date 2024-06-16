package com.example.myblossom.ui.patient.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myblossom.R
import com.example.myblossom.databinding.FragmentArticleBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.myblossom.adapter.ArticleAdapter
import com.example.myblossom.model.ArticleModel


class ArticleFragment : Fragment(), ArticleAdapter.OnItemClickListener {
    private lateinit var dbReference: DatabaseReference
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleList: ArrayList<ArticleModel>
    private lateinit var binding: FragmentArticleBinding

    companion object {
        const val ARTICLE = "Article"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFirebase()
        setupRecyclerView()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (query != null) {
                    articleAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    articleAdapter.filter.filter(newText)
                }
                return true
            }
        })
    }

    private fun initFirebase() {
        val db = FirebaseDatabase.getInstance()
        dbReference = db.reference.child(ARTICLE)

        dbReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                articleList.clear()
                for (articleSnap in snapshot.children) {
                    articleSnap.getValue(ArticleModel::class.java)?.let { articleModel ->
                        articleModel.title = articleSnap.key.toString()
                        articleList.add(articleModel)
                    }
                }
                articleAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                showToast("${error.details} ${error.message}")
            }
        })
    }

    private fun setupRecyclerView() {
        articleList = ArrayList()
        articleAdapter = ArticleAdapter(this, articleList)
        articleAdapter.setOnItemClickListener(this)
        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
    }

    override fun onItemClick(article: ArticleModel?) {
        article?.let {
            val fragment = ArticleDetailFragment.newInstance(it)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)  // Make sure R.id.container is the correct container
                .addToBackStack(null)
                .commit()
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }
}