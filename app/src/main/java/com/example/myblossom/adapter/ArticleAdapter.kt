package com.example.myblossom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myblossom.databinding.ItemArticleBinding
import java.util.Locale
import android.widget.Filter
import com.example.myblossom.ui.patient.fragment.ArticleFragment
import com.example.myblossom.model.ArticleModel

class ArticleAdapter(
    private val context: ArticleFragment,
    private var originalArticleList: ArrayList<ArticleModel>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(), Filterable {

    private var filteredArticleList: ArrayList<ArticleModel> = originalArticleList
    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(article: ArticleModel?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(filteredArticleList[position])
    }

    override fun getItemCount(): Int {
        return filteredArticleList.size
    }

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(article: ArticleModel?) {
            binding.tvTitle.text = article?.title
            Glide.with(context).load(article?.image).into(binding.ivImage)
        }

        override fun onClick(v: View?) {
            listener?.onItemClick(filteredArticleList[adapterPosition])
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = mutableListOf<ArticleModel>()
                if (constraint.isNullOrBlank()) {
                    filteredResults.addAll(originalArticleList)
                } else {
                    val query = constraint.toString().lowercase(Locale.getDefault())
                    for (article in originalArticleList) {
                        if (article.title?.lowercase(Locale.getDefault())?.contains(query) == true) {
                            filteredResults.add(article)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredResults
                return filterResults
            }
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredArticleList = results?.values as? ArrayList<ArticleModel> ?: ArrayList()
                notifyDataSetChanged()
            }
        }
    }
}