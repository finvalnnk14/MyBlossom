package com.example.myblossom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myblossom.databinding.FragmentArticleDetailBinding

@Suppress("DEPRECATION")
class ArticleDetailFragment : Fragment() {
    private lateinit var binding: FragmentArticleDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = arguments?.getString("image")
        val title = arguments?.getString("title")
        val content = arguments?.getString("content")
        val source = arguments?.getString("source")

        // Replace "_n" with "\n" in the content string
        val formattedContent = content?.replace("_n", "\n") ?: "No Description"

        binding.apply {
            articleTitle.text = title
            articleContent.text = formattedContent
            articleSource.text = source
            // Load the image using your preferred image loading library, e.g., Glide
            Glide.with(this@ArticleDetailFragment)
                .load(image)
                .into(articleImage)
        }
    }

    companion object {
        fun newInstance(article: ArticleModel): ArticleDetailFragment {
            val fragment = ArticleDetailFragment()
            val args = Bundle().apply {
                putString("image", article.image)
                putString("title", article.title)
                putString("content", article.content)
                putString("source", article.source)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
