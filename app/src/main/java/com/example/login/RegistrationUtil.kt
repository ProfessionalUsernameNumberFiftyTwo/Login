package com.example.login

// object keyword makes it so all the functions are static functions
object RegistrationUtil {
    // make sure it is not empty for each function



    fun validateName(name : String) : Boolean {
        return true
    }

    // swear filter
    // already taken
    // real name can't be used
    // meet minimum characters
    // other req.
    fun validateUserName(username : String) : Boolean {
        return true
    }

    // make sure password meets security requirements (deprecated standards)
        // min 8 chars
        // at least one digit
        // at least one capital letter
    // make sure both passwords match
    fun validatePassword(password : String, confirmPassword : String) : Boolean {
        return true
    }

    // make sure the email is not used
    // make sure it is in the proper email format: user@domain.tld
    fun validateEmail(email : String) : Boolean {
        return true
    }
}