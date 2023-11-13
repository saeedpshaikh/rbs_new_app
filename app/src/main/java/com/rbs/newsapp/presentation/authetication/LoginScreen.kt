package com.rbs.newsapp.presentation.authetication

import android.transition.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rbs.newsapp.R
import com.rbs.newsapp.Screen
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.ui.theme.BackGroundColor
import com.rbs.newsapp.ui.theme.RedGroundColor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    navController: NavController,
    dataStore: Datastore,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var textUser by rememberSaveable { mutableStateOf("") }
    var textPas by rememberSaveable { mutableStateOf("") }
    var topView by rememberSaveable { mutableStateOf(false) }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    if (topView) ErrorCompose(errorMessage) {
        topView = it
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 180.dp, start = 20.dp, end = 20.dp, bottom = 60.dp)
            .background(color = BackGroundColor)
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.app_name),
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Box(
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.height(100.dp))
                var text by rememberSaveable { mutableStateOf("") }

                Box(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .align(Alignment.Start)
                        .width(500.dp)
                )
                {
                    Text(
                        textAlign = TextAlign.Start,
                        text = stringResource(id = R.string.user_name)
                    )
                }

                Spacer(modifier = Modifier.padding(3.dp))
                Box(
                    Modifier.background(color = Color.White)
                ) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )
                    )
                    textUser = text
                }
                Spacer(modifier = Modifier.padding(5.dp))
                var password by rememberSaveable { mutableStateOf("") }
                var passwordHidden by rememberSaveable { mutableStateOf(true) }

                Box(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .align(Alignment.Start)
                        .width(500.dp)
                )
                {
                    Text(
                        textAlign = TextAlign.Start,
                        text = stringResource(id = R.string.password)
                    )
                }
                Box(
                    Modifier.background(
                        color = Color.White
                    )
                ) {
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },

                        visualTransformation =
                        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        trailingIcon = {
                            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                val iconImage =
                                    if (passwordHidden) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
                                Icon(
                                    painter = painterResource(id = iconImage),
                                    contentDescription = "Trailing Icon",
                                    tint = Color.Gray
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )
                    )
                    textPas = password
                }

                val gradientColor = listOf(Color(0xffDE1313), Color(0xffDE1313))
                Spacer(modifier = Modifier.padding(20.dp))
                GradientButton(
                    gradientColors = gradientColor,
                    cornerRadius = 0.dp,
                    nameButton = "Login",
                    roundedCornerShape = RoundedCornerShape(topStart = 0.dp, bottomEnd = 0.dp),
                    navController = navController,
                    LoginViewModel = loginViewModel,
                    textUser,
                    textPas,
                    messageChange = {
                        errorMessage =
                            it
                    },
                    changeTopFlag = { topView = it } ,
                    dataStore
                )
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}

@Composable
private fun GradientButton(
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    roundedCornerShape: RoundedCornerShape,
    navController: NavController,
    LoginViewModel: LoginViewModel,
    textUserT: String,
    textUserP: String,
    messageChange: (message: String) -> Unit,
    changeTopFlag: (flag: Boolean) -> Unit,
    dataStore: Datastore

    ) {
    val coroutineScope = rememberCoroutineScope()
    androidx.compose.material3.Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            if (!LoginViewModel.isValidUser(textUserT)) {
                messageChange("Please enter valid user name")
                changeTopFlag(true)

            } else if (!LoginViewModel.isValidPassword(textUserP)) {
                messageChange("Please enter valid password")
                changeTopFlag(true)
            } else {
                changeTopFlag(false)
                coroutineScope.launch {
                    dataStore.storeNewsData(textUserT)
                    delay(10)
                }

                //coroutineScope

                navController.navigate(Screen.NewsScreen.route)
            }
            //navController.navigate(Screen.NewsScreen.route)
        },
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ErrorCompose(message: String, onClick: (x: Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BackGroundColor)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (textErrorMessage, textMassage, imageClose) = createRefs()
            Image(
                painter = painterResource(R.drawable.img_close),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(0.dp)
                    .width(20.dp)
                    .height(20.dp)
                    .clickable {
                        onClick(false)
                    }
                    .constrainAs(imageClose) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            Text(text = "Error",
                color = RedGroundColor,
                modifier = Modifier
                    .padding(0.dp)
                    .constrainAs(textErrorMessage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )
            Text(text = message,
                modifier = Modifier
                    .padding(0.dp)
                    .constrainAs(textMassage) {
                        top.linkTo(textErrorMessage.bottom)
                        start.linkTo(parent.start)

                    }
            )
        }
    }
}

