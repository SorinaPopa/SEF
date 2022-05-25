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

    lateinit var sharedPreferences: SharedPreferences
    var isOrganiser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        setContentView(binding.root)
        supportActionBar?.hide()

        sharedPreferences = getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )
        subscribeToObserver()

    }

    private fun subscribeToObserver() {
        loginViewModel.onLoginButtonClicked.observe(this) { value ->
            if (value) {
                processLogin()
            }
        }
    }

    private fun processLogin() {
        val editor = sharedPreferences.edit()
        editor.putBoolean(IS_ORGANISER, loginViewModel.isOrganiserCodeValid())
        editor.apply()
        if (!loginViewModel.isOrganiserCodeValid() && loginViewModel.onOrganiserChecked.value == true) {
            Toast.makeText(this, "Invalid organiser code", Toast.LENGTH_LONG).show()
        } else if(!loginViewModel.isUserValid()){
            Toast.makeText(this, "Invalid organiser code", Toast.LENGTH_LONG).show()
        }else{
            signInValidation()
        }
    }

    private fun signInValidation() {
        val button: Button = findViewById(R.id.SignIn)
        button.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        private const val IS_ORGANISER = "is.organiser"
    }

}