package com.rbs.newsapp.domain.news_usecase

data class NewsListState(
    val isLoading: Boolean = false,
    var news: Any? = null,
    val error: String = ""
)
