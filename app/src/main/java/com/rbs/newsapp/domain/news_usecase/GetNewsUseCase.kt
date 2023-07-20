package com.rbs.newsapp.domain.news_usecase


import com.rbs.newsapp.common.Resource
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.data.remote.dto.NewModel
import com.rbs.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository) {
    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        try {
            val recipeInfo = repository.getNews()
            emit(Resource.Success<List<Article>>(recipeInfo.articles))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Article>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Article>>("Couldn't reach server. Check your internet connection."))
        }
    }

   // suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

}