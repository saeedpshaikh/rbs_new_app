package com.rbs.newsapp.presentation.news_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.rbs.newsapp.R
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.ui.theme.WhiteGroundColor

@Composable
fun NewsListItem(article: Article, onItemClick: (Article) -> Unit) {
    Column( modifier = Modifier
        .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
        .fillMaxWidth()
        .background(color = WhiteGroundColor)
       ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .clickable { onItemClick(article) }
                .padding(1.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${article.description})",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = rememberAsyncImagePainter(article.urlToImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp))

            testComposable(article)

        }



    }


}

//@Preview(showBackground = true)
@Composable
fun testComposable(article: Article) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = CenterVertically
        ) {
        Image(
            painter = painterResource(R.drawable.img_close),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
           Column() {
               Text(
                   text = "${article.author})",
                   style = MaterialTheme.typography.body1,
                   maxLines = 1,
                   fontSize = 13.sp,
                   overflow = TextOverflow.Ellipsis
               )

               Spacer(modifier = Modifier
                   .height(1.dp)
                   .width(45.dp)
                   .background(color = Color.Black)
               )
           }

            Text(
                text = "${article.publishedAt})",
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                fontSize = 13.sp,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${article.content})",
                style = MaterialTheme.typography.body1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}