package com.rbs.newsapp.presentation.news_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.presentation.news_list.component.NewsListItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun NewsListScreen(
    navController: NavController,
    dataStore:Datastore,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.article) { article ->
                NewsListItem(
                    article = article,
                    onItemClick = {
                        var jsonData = article.toString()


                        viewModel.setArticle(article)
                         navController.navigate(Screen.NewDetailScreen.route + "/${"id"}")

                        /*coroutineScope.launch {
                            dataStore.storeNewsData(jsonData)
                            val gson = Gson()
                            var myObjectString = gson.toJson(article, Article::class.java)
                            //navController.navigate("details/$myObjectString")
                           // navController.navigate(Screen.NewDetailScreen.route + "/${myObjectString.toString()}")
                        }*/
                    }
                )
            }
        }
        if(state.error.isNotBlank()) {
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
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}
