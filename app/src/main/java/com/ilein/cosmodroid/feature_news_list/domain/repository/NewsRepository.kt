package com.ilein.cosmodroid.feature_news_list.domain.repository

import com.ilein.cosmodroid.feature_news_list.domain.model.DetailNewsModel
import com.ilein.cosmodroid.feature_news_list.domain.model.NewsPreviewModel

interface NewsRepository {
    suspend fun getNewsList(): List<NewsPreviewModel>
    suspend fun getDetailNews(id:Int): DetailNewsModel
}
