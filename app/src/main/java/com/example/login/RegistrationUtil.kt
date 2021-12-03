package com.example.login

// object keyword makes it so all the functions are static functions
object RegistrationUtil {
    var existingUsers = listOf("cosmicFry", "cosmicY", "bob", "alice", "ToadForSteam")
    var usedEmails = listOf("cosmic@fry.org", "y@cosmic.com", "bob@bob.bob", "alicealice@bob.bob", "ToadForSteam@mgail.com")
    // You can use listOf<type>() instead of making a list and adding individually

    // make sure it is not empty for each function

    fun validateName(name : String) : Boolean {
        return name.isNotEmpty()
    }

    // swear filter(?)
    // already taken
    // real name can't be used
    // meet minimum characters
    // other req.
    fun validateUserName(username : String, name: String) : Boolean {
        if (existingUsers.indexOf(username) >= 0) return false
        if (username.length < 8) return false
        return username.indexOf(name) == -1
    }

    // make sure password meets security requirements (deprecated standards)
        // min 8 chars
        // at least one digit
        // at least one capital letter
    // make sure both passwords match
    fun validatePassword(password : String, confirmPassword : String) : Boolean {
        if (password.length < 8) return false
        if (password.equals(password.lowercase())) return false
        for (i in password) {
            if (i in '0'..'9') return password.equals(confirmPassword)
        }
        return false
    }

    // make sure the email is not used
    // make sure it is in the proper email format: user@domain.tld
    fun validateEmail(email : String) : Boolean {
        if (usedEmails.indexOf(email) >= 0) return false
        if (email.indexOf("@") == -1 || email.indexOf(".") == -1 || email.indexOf(" ") >= 0) return false
        if (email.indexOf(".",email.indexOf("@")) == -1) return false
        return !email.substring(email.indexOf("@") + 1, email.indexOf("@") + 2).equals(".")
    }
}