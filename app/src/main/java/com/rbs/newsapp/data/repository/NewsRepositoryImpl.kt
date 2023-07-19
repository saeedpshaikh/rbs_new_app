package com.rbs.newsapp.data.repository


import com.rbs.newsapp.data.remote.NewsRetroApi
import com.rbs.newsapp.data.remote.dto.NewModel
import com.rbs.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsRetroApi) : NewsRepository {
    override suspend fun getNews(): NewModel {
        return api.getNews("tesla", "2023-18-07")
    }
}