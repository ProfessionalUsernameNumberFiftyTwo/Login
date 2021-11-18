package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // any time a static object would be required in java, use companion object in kotlin
    // the variable can be accessed with ClassName.VARIABLE_NAME like Math.PI
    companion object {
        val EXTRA_USERNAME = "username" // key for key-value pair for the intent extras
        val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginCreateAccount.setOnClickListener {
            // launch the registration activity
            // pass the values of username and password along to the new activity
            // 1. extract any info needed from editTexts
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()
            // 2. create the intent and package the extras
            // extra refers to the information that is passed through with the intent
            // the context is the current activity (this)
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }
            // 3. launch the activity
            startActivity(registrationIntent)
        }

    }
}