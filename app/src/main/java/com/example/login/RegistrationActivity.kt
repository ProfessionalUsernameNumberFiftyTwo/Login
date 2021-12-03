package com.example.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // access any values that were sent from the intent that launched this activity
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user: $username pwd: $password", Toast.LENGTH_SHORT).show()

        binding.buttonRegistrationRegister.setOnClickListener {
            // TODO: verify that information entered is valid


            // in a real app, we'd talk to a database here and save the new user

            // return to the login screen and send back the user & password to prefill
            var returnToLoginIntent = Intent().apply {
                putExtra(LoginActivity.EXTRA_USERNAME, binding.editTextRegistrationUsername.text.toString())
                putExtra(LoginActivity.EXTRA_PASSWORD, binding.editTextRegistrationPassword.text.toString())
            }
            if (!RegistrationUtil.validateName(binding.editTextRegistrationName.text.toString()))
            {
                Toast.makeText(this, "Please add a name.", Toast.LENGTH_SHORT).show()
            }
            else if (!RegistrationUtil.validateUserName(binding.editTextRegistrationUsername.text.toString(),binding.editTextRegistrationName.text.toString()))
            {
                Toast.makeText(this, "Username is invalid.", Toast.LENGTH_SHORT).show()
            }
            else if (!RegistrationUtil.validateEmail(binding.editTextRegistrationEmail.text.toString()))
            {
                Toast.makeText(this, "Email is invalid.", Toast.LENGTH_SHORT).show()
            }
            else if (!RegistrationUtil.validatePassword(binding.editTextRegistrationPassword.text.toString(),binding.editTextRegistrationConfirmPassword.text.toString()))
            {
                Toast.makeText(this, "Password is invalid/Passwords do not match.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                setResult(Activity.RESULT_OK, returnToLoginIntent)
                finish()
            }


        }
    }
}