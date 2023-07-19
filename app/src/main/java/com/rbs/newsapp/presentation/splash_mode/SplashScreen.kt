package com.rbs.newsapp.presentation.splash_mode

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.rbs.newsapp.Screen
import com.rbs.newsapp.presentation.SplashViewModel
import com.rbs.newsapp.presentation.news_list.NewsListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

//@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController,viewModel: SplashViewModel = hiltViewModel()) {
    /* Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {

        Column(modifier = Modifier
            .align(Alignment.Center)) {

            Box(modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Color.Red)
            )

            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Box(modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Color.Red)
                )

            }

        }


    }
*/



    ConstraintLayout(
        modifier = Modifier.fillMaxSize()

    ) {
        val (boxGreen, boxRed, boxBlue, rowLayoutAppName, rowLayout) = createRefs()
        Box(modifier = Modifier
            .height(60.dp)
            .width(60.dp)


            //modifier = Modifier.align(Alignment.TopEnd).size(10.dp)
            .constrainAs(boxRed) {
                //  top.linkTo(parent.top, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

            .background(color = Color.Red)
        )


        Box(modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            }
            .background(color = Color.Green)
        )

        Box(modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxGreen.end)
            }
            .background(color = Color.Blue)
        )


        Text(text = "Application name",
            fontSize = 22.sp,
            modifier = Modifier
                .constrainAs(rowLayoutAppName) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


        Row(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(rowLayout) {
                top.linkTo(rowLayoutAppName.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Color.Black)
            )

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Color.Blue)
            )

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Color.Yellow)
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(5.seconds)
        //navController.navigate(Screen.LoginScreen.route)
    }

}