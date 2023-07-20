package com.rbs.newsapp.presentation.news_detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.presentation.news_list.NewsListViewModel
import com.rbs.newsapp.ui.theme.AllGroundColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsDetailScreen(
    navController: NavController,
    datastore: Datastore,
    /*viewModel: NewsDetailViewModel = hiltViewModel()*/

    viewModel: NewsListViewModel = hiltViewModel()
) {
    //val state = viewModel.state.value
    val coroutineScope = rememberCoroutineScope()
    lateinit  var article : Article

    coroutineScope.launch {
        val getData= datastore.jsonNameFlow.collect{

            Log.d("====",it)

            article = Gson().fromJson(it, Article::class.java)

            viewModel.setArticle(article)

            }

        }



   /* runBlocking {
        delay(5000)
    }*/

    Column( modifier = Modifier
        .fillMaxWidth()
        .background(color= AllGroundColor)
        .padding(20.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(1.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = rememberAsyncImagePainter(viewModel.getArticle().value.urlToImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = "${viewModel.getArticle().value.description})",
                style = MaterialTheme.typography.body1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${viewModel.getArticle().value.description})",
                style = MaterialTheme.typography.body1,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )

        }
    }

}