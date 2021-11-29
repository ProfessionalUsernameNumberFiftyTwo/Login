package com.example.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // any time a static object would be required in java, use companion object in kotlin
    // the variable can be accessed with ClassName.VARIABLE_NAME like Math.PI
    companion object {
        val EXTRA_USERNAME = "username" // key for key-value pair for the intent extras
        val EXTRA_PASSWORD = "password"
    }

    // starting an activity for a result
    // Step 1: Register the Activity with a contract
    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        // decide what to do if the result is ok (if it was successful)
        if (result.resultCode == Activity.RESULT_OK)
        {
            val intent = result.data
            // Handle the Intent
            // Note: editTexts are different than textViews in that you must call setText
            binding.editTextLoginUsername.setText(intent?.getStringExtra(LoginActivity.EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(LoginActivity.EXTRA_PASSWORD))
        }
        else
        {
            Toast.makeText(this, "Registration canceled: Empty username and/or password", Toast.LENGTH_SHORT).show()
        }
        // decide what to do if the result is unsuccessful with RESULT_CANCELED
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
            //startActivity(registrationIntent)

            // 3b. Alternate: Could launch the activity for a result instead
            startRegistrationForResult.launch(registrationIntent)

        }

    }
}