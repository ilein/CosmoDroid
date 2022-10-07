package com.ilein.cosmodroid.feature_news_list.presentation.adapter

import com.ilein.cosmodroid.R
import com.ilein.cosmodroid.databinding.ItemNewsLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.ilein.cosmodroid.feature_news_list.presentation.model.NewsItem

class NewsAdapter() :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val itemBinding: ItemNewsLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)
    private var newsList: MutableList<NewsItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ItemNewsLayoutBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news_layout, parent, false)
            )
        )

    fun setNewsList(list: List<NewsItem>){
        newsList.clear()
        newsList.addAll(list)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        with(holder.itemBinding) {
            dateOfNews.text = newsList[position].date
            typeOfNews.text = newsList[position].type.name
            previewOfNews.text = newsList[position].description
            imageOfNews.load(newsList[position].featureImage)
        }
    }

    override fun getItemCount() = newsList.size
}