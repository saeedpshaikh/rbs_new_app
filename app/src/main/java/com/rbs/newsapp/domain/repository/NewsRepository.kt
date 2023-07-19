package com.rbs.newsapp.domain.repository

import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.data.remote.dto.NewModel

interface NewsRepository {
    suspend fun getNews(): NewModel
}