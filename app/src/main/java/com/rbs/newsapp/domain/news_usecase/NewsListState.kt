package com.rbs.newsapp.domain.news_usecase

import com.rbs.newsapp.data.remote.dto.Article

data class NewsListState(
    val isLoading: Boolean = false,
    val article: List<Article> = emptyList(),
    val error: String = ""
)
