package com.rbs.newsapp.presentation.splash_mode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rbs.newsapp.Screen
import com.rbs.newsapp.presentation.SplashViewModel
import com.rbs.newsapp.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(navController: NavController,viewModel: SplashViewModel = hiltViewModel()) {

    callThisMethod()

    LaunchedEffect(Unit) {
        delay(5.seconds)
        navController.navigate(Screen.LoginScreen.route)
    }

}

@Preview(showBackground = true)
@Composable
private fun callThisMethod() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (mainParentLayout, boxRed,boxGreen, boxBlue, rowLayoutAppName, rowLayout) = createRefs()

        ConstraintLayout(modifier = Modifier.padding(start = 100.dp,top=250.dp)
            .constrainAs(mainParentLayout) {
                top.linkTo(parent.top)
                start.linkTo(parent.start) }) {

            Box(modifier = Modifier
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .height(60.dp)
                .width(60.dp)
                .background(color = RedGroundColor)
            )
            Box(modifier = Modifier
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                }
                .height(60.dp)
                .width(60.dp)
                .background(color = GreenGroundColor)
            )
            Box(modifier = Modifier
                .constrainAs(boxBlue) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxGreen.end)
                }
                .height(60.dp)
                .width(60.dp)
                .background(color = BlueGroundColor)
            )
        }

        Text(text = "Application name",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(top = 30.dp)
                .constrainAs(rowLayoutAppName) {
                    top.linkTo(mainParentLayout.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


        Row(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth()
                .constrainAs(rowLayout) {
                    top.linkTo(rowLayoutAppName.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }, horizontalArrangement = Arrangement.SpaceEvenly) {
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = OrangeGroundColor)){
                Text(text = "A",
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.Center))
            }

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = Purple200 )) {
                Text(text = "B",
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.Center))
            }

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(color = GreenGroundColor )){
                Text(text = "C",
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
