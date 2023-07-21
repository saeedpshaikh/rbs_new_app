package com.rbs.newsapp.common

class Constants {
    companion object {
        //const val API_KEY = "d6e6886d0f8c46f18793b5d35cd833f1"
        const val API_KEY = "916f9459d34a46d39a51170c121467bd"
        private const val REGEX_STRONG_PASSWORD = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,})"
        const val PARAM_NEW_DATA = "newsData"
        const val PARAM_ARTICLE_DATA = "article"
    }
}