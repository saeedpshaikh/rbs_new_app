package com.rbs.newsapp.presentation.authetication


import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    //- Passwords field should not be empty and should contain One Capital case, one small case, one digit.
    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +
                "(?=.*\\d)" +  // at least 1 digit
                "(?=\\S+$)" +  // no white spaces
                "(?=.*[A-Z])"+
                "(?=.*[a-z])"+
                "$"
    )
    fun isValidEmail(email: String): Boolean {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(emailRegex)
    }

}