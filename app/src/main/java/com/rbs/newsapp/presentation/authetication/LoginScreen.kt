package com.rbs.newsapp.presentation.authetication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(/*navController: NavController*/) {


        Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = Color.Transparent,
                )
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val mUsername = remember { mutableStateOf("") }
                    val mPassword = remember { mutableStateOf("") }
                    Spacer(modifier = Modifier.height(150.dp))
                    SimpleOutlinedTextFieldSample()
                    Spacer(modifier = Modifier.padding(3.dp))
                    SimpleOutlinedPasswordTextField()
                    val gradientColor = listOf(Color(0xffDE1313), Color(0xffDE1313))
                    Spacer(modifier = Modifier.padding(10.dp))
                    GradientButton(
                        gradientColors = gradientColor,
                        cornerRadius = 0.dp,
                        nameButton = "Login",
                        roundedCornerShape = RoundedCornerShape(topStart = 0.dp,bottomEnd = 0.dp)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Spacer(modifier = Modifier.padding(5.dp))
                    Spacer(modifier = Modifier.padding(20.dp))

                }


            }

        }


    }


    //...........................................................................
    @Composable
    private fun GradientButton(
        gradientColors: List<Color>,
        cornerRadius: Dp,
        nameButton: String,
        roundedCornerShape: RoundedCornerShape
    ) {

        androidx.compose.material3.Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            onClick = {
                //your code
                //mUsername
                Log.d("======Login","9999")

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
                    /*.background(
                        brush = Brush.linearGradient(colors = gradientColors),
                        shape = RoundedCornerShape(cornerRadius)
                    )*/
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
