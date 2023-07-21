package com.rbs.newsapp.presentation.news_list

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.rbs.newsapp.Screen
import com.rbs.newsapp.common.Constants.Companion.PARAM_ARTICLE_DATA
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.presentation.news_detail.NewsDetailScreen
import com.rbs.newsapp.presentation.news_list.component.AppBarUI
import com.rbs.newsapp.presentation.news_list.component.NewsListItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsListScreen(
    navController: NavController,
    dataStore: Datastore,
    viewModel: NewsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val coroutineScope = rememberCoroutineScope()
    var name:String? =""

    coroutineScope.launch {
         name = dataStore.nameFlow.toString()
        name= dataStore.nameFlow.collect().toString()
    }

    Column() {

        name?.let { AppBarUI(it) }
        Box(modifier = Modifier.fillMaxSize()) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.article) { article ->
                    NewsListItem(
                        article = article,
                        onItemClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                key = PARAM_ARTICLE_DATA,
                                value = article
                            )
                            navController.navigate(Screen.NewDetailScreen.route)
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
