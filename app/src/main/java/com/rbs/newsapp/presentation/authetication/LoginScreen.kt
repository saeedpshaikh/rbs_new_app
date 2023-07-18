package com.rbs.newsapp.presentation.authetication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(Color.Blue)
    )
    Column {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Green)
        )

    }
}