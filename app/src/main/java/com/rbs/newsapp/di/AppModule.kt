package com.rbs.newsapp.di

import com.rbs.newsapp.BuildConfig
import com.rbs.newsapp.data.remote.NewsRetroApi
import com.rbs.newsapp.data.repository.NewsRepositoryImpl
import com.rbs.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): NewsRetroApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsRetroApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: NewsRetroApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }

}