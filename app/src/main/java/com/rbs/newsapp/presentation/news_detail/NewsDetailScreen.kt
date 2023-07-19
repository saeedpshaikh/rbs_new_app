package com.rbs.newsapp.presentation.news_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rbs.newsapp.presentation.news_list.NewsListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    //val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
          //  items(state.coins) { coin ->
                /*CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    }
                )*/
            }
        }
       /* if(state.error.isNotBlank()) {
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
        }*/
    }
//}