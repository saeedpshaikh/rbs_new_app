package com.rbs.newsapp.data.remote

import com.rbs.newsapp.common.Constants.Companion.API_KEY
import com.rbs.newsapp.data.remote.dto.NewModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRetroApi {

    //everything?q=tesla&from=2023-18-07&sortBy=publishedAt&apiKey=d6e6886d0f8c46f18793b5d35cd833f1
    @GET("/v1/everything")
    suspend fun getNews(@Query("q") searchQuery: String, @Query("page") pageNumber: Int = 1, @Query("apiKey") apiKey: String = API_KEY): NewModel


}
