package com.rbs.newsapp.presentation.news_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rbs.newsapp.common.Constants
import com.rbs.newsapp.common.Datastore

class NewsDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel(


) {

    init {
        savedStateHandle.get<String>(Constants.PARAM_NEW_DATA)?.let { newsData ->
            Log.d("====",newsData)
        }

       /* dataStore.asLiveData().observe(this) {
            age = it
            tvAge.text = it.toString()
        }*/
    }
}