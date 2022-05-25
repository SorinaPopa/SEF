package com.example.stadevents.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.example.stadevents.MainActivity
import com.example.stadevents.R
import com.example.stadevents.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding
    private val loginViewModel: LoginViewModel by viewModels()

    lateinit var sharedPreferencesOrganiser: SharedPreferences
    var isOrganiser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        setContentView(binding.root)
        supportActionBar?.hide()

        sharedPreferencesOrganiser = getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )

        loginViewModel.onOrganiserChecked.observe(this) { value ->
            if (value) {
                //validationCodeTextView is visible
            } else {
                //validationCodeTextView is invisible
            }
            isOrganiser = sharedPreferencesOrganiser.getBoolean("CHECKBOX", false)

        }

        loginViewModel.onLoginButtonClicked.observe(this) { value ->
            if (value) {
                if (loginViewModel.loginOrganiser()) {
                    //isOrganiser = true
                    signInValidation()
                } else {
                    if (loginViewModel.loginCustomer()) {
                        //isOrganiser = false
                        signInValidation()
                    } else {
                        Toast.makeText(this, "Invalid", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }

//        loginViewModel.onLoginButtonClicked.observe(this) { value ->
//            if (value) {
//                if (loginViewModel.loginCustomer()) {
//                    val button: Button = findViewById(R.id.SignIn)
//                    button.setOnClickListener {
//                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                } else {
//                    Toast.makeText(this, "Invalid", Toast.LENGTH_LONG).show()
//                }
//
//            }
    }

    private fun signInValidation() {
        val button: Button = findViewById(R.id.SignIn)
        button.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}