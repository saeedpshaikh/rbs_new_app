package com.rbs.newsapp.presentation.authetication


import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {
    fun isValidUser(user: String): Boolean {
        val regexPattern = Regex("^(?!\\d+\$)[^\\s@]+@[^\\s@]+\\.[^\\s@]+\$")
        return regexPattern.matches(user)
    }

    fun isValidPassword(password: String): Boolean {
        val regexPattern = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")
        return regexPattern.matches(password)
    }

}

