package com.rbs.newsapp.presentation.authetication

import android.transition.*
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rbs.newsapp.Screen
import com.rbs.newsapp.ui.theme.BackGroundColor


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(top = 180.dp, start = 10.dp, end = 10.dp, bottom = 60.dp)
        .background(
            color = BackGroundColor
        )
        ) {

        Row (Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                textAlign = TextAlign.Center,
                text = "ApplicationName",
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

                    val mUsername = remember { mutableStateOf("") }
                    val mPassword = remember { mutableStateOf("") }
                    Spacer(modifier = Modifier.height(150.dp))
                   // SimpleOutlinedTextFieldSample()
                    var text by rememberSaveable { mutableStateOf("") }
                    Text(
                        text = "Username",
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Box(
                        Modifier.background(color = Color.White)
                    ) {

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text(text = "Name or Email Address") },
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
                    }
                    Spacer(modifier = Modifier.padding(3.dp))
                    var password by rememberSaveable { mutableStateOf("") }
                    var passwordHidden by rememberSaveable { mutableStateOf(true) }

                    Text(text = "Password")
                    Box( Modifier.background(
                        color = Color.White
                    )) {
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
                                    /*val visibilityIcon =
                                        if (passwordHidden) Visibility else*/
                                    val description =
                                        if (passwordHidden) "Show password" else "Hide password"
                                }
                            },
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    keyboardController?.hide()
                                }
                            )
                        )
                    }

                    //SimpleOutlinedPasswordTextField()
                    val gradientColor = listOf(Color(0xffDE1313), Color(0xffDE1313))
                    Spacer(modifier = Modifier.padding(10.dp))
                    GradientButton(
                        gradientColors = gradientColor,
                        cornerRadius = 0.dp,
                        nameButton = "Login",
                        roundedCornerShape = RoundedCornerShape(topStart = 0.dp,bottomEnd = 0.dp),
                        navController= navController
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
        navController: NavController
    ) {
        androidx.compose.material3.Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            onClick = {
                navController.navigate(Screen.NewsScreen.route)
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


    //email id
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun SimpleOutlinedTextFieldSample() {
        val keyboardController = LocalSoftwareKeyboardController.current
        var text by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text("Name or Email Address",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.subtitle1,
                ) },
            placeholder = { Text(text = "Name or Email Address") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primary),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )

        )
    }

    //password
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun SimpleOutlinedPasswordTextField() {
        val keyboardController = LocalSoftwareKeyboardController.current
        var password by rememberSaveable { mutableStateOf("") }
        //passwordGlobal = password
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text("Enter Password",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.subtitle1,
                ) },
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primary),
            trailingIcon = {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    //val visibilityIcon =
                       // if (passwordHidden) android.transition.Visibility else VisibilityOff
                    // Please provide localized description for accessibility services
                    val description = if (passwordHidden) "Show password" else "Hide password"
                   // Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )
        )
    }
