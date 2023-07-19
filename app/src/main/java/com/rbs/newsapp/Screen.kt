package com.rbs.newsapp

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object LoginScreen: Screen("login_screen")

    object NewsScreen: Screen("news_screen")

    object NewDetailScreen: Screen("news_detail_screen")
}
