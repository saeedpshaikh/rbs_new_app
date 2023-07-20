package com.rbs.newsapp.presentation.news_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.ui.theme.AllGroundColor
import com.rbs.newsapp.ui.theme.GreenGroundColor
import kotlinx.coroutines.launch

@Composable
fun NewsListItem(article: Article, onItemClick: (Article) -> Unit) {


    Column( modifier = Modifier
        .fillMaxWidth()
        .background(color= AllGroundColor)
        .padding(20.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White )
                .clickable { onItemClick(article)

                }
                .padding(1.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${article.description})",
                style = MaterialTheme.typography.body1,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = rememberAsyncImagePainter(article.urlToImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp))
        }
    }




}