package com.rbs.newsapp.presentation.news_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.rbs.newsapp.R
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.data.remote.dto.Article
import com.rbs.newsapp.presentation.news_list.NewsListViewModel
import com.rbs.newsapp.presentation.news_list.component.AppBarUI
import com.rbs.newsapp.presentation.news_list.component.testComposable
import com.rbs.newsapp.ui.theme.AllGroundColor
import com.rbs.newsapp.ui.theme.RedGroundColor
import kotlinx.coroutines.NonDisposableHandle.parent

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsDetailScreen(
    navController: NavController,
    datastore: Datastore,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("person")

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color= AllGroundColor)
        .padding(20.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(1.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AppBarUI("name")
            Image(
                painter = rememberAsyncImagePainter(article?.urlToImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )


            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.img_close),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Column() {
                        Text(
                            text = "${article?.author})",
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
                        text = "${article?.publishedAt})",
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        fontSize = 13.sp,
                        overflow = TextOverflow.Ellipsis
                    )


                }
            }


            Text(
                text = "${article?.description})",
                style = MaterialTheme.typography.body1,
                maxLines = 3,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier
                .height(20.dp)
            )
            Text(
                text = "${article?.content})",
                style = MaterialTheme.typography.body1,
                fontSize = 15.sp,
                maxLines = 9,
                overflow = TextOverflow.Ellipsis
            )

            //article?.let { testComposable(it) }



        }


    }
}