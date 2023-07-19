package com.rbs.newsapp.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.rbs.newsapp.Screen
import com.rbs.newsapp.presentation.authetication.LoginScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val mutableStateFlow = MutableStateFlow(true)

    init {
        viewModelScope.launch {
            delay(100000)
            mutableStateFlow.value = false
        }

    }
}


