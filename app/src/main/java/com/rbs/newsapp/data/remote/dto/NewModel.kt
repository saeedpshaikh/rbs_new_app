package com.rbs.newsapp.data.remote.dto

data class NewModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)