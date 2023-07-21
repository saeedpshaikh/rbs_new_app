package com.rbs.newsapp.presentation.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbs.newsapp.common.Resource
import com.rbs.newsapp.domain.news_usecase.GetNewsUseCase
import com.rbs.newsapp.domain.news_usecase.NewsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {
    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    init {
        getNews()
    }
    private fun getNews() {
        getNewsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsListState(article = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NewsListState(
                        error = result.message ?: "An unexpected error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}