package com.rbs.newsapp.data.remote

import com.rbs.newsapp.common.Constants.Companion.API_KEY
import com.rbs.newsapp.data.remote.dto.NewModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRetroApi {

    //everything?q=tesla&from=2023-18-07&sortBy=publishedAt&apiKey=d6e6886d0f8c46f18793b5d35cd833f1
    @GET("/v2/everything")
    suspend fun getNews(
        @Query("q") data: String = "tesla",
        @Query("from") dateData: String = "2023-18-07",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = API_KEY,
    ): NewModel

// @Query("apiKey") apiKey: String = API_KEY
}
