package com.rbs.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rbs.newsapp.Screen
import com.rbs.newsapp.common.Datastore
import com.rbs.newsapp.presentation.authetication.LoginScreen
import com.rbs.newsapp.presentation.news_detail.NewsDetailScreen
import com.rbs.newsapp.presentation.news_list.NewsListScreen
import com.rbs.newsapp.presentation.splash_mode.SplashScreen
import com.rbs.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()
    lateinit var dataStore: Datastore

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            dataStore = Datastore(this)
            // ArticleDatabase(this)
            Navigation(dataStore)

            //val newsRepository = NewsRepository(ArticleDatabase(this))

        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        Greeting("Android")
    }
}

@Composable
fun Navigation(dataStore: Datastore) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(route= Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable("login_screen"){

            LoginScreen(navController)
        }
        composable("news_screen"){
            NewsListScreen(navController, dataStore)
        }

        composable(
            route = Screen.NewDetailScreen.route + "/{new}"
        ) {
            NewsDetailScreen(navController, dataStore)
        }

    }
}
