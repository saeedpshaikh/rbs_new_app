package com.rbs.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val mutableStateFlow = MutableStateFlow(true)
    init {
        viewModelScope.launch {
            delay(10)
            mutableStateFlow.value = false
        }
    }
}


