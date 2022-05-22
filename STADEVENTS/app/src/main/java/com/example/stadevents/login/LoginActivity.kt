package com.example.stadevents.login

import android.content.Intent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        setContentView(binding.root)
        supportActionBar?.hide()

        loginViewModel.onLoginButtonClicked.observe(this) { value ->
            if (value) {
                if (loginViewModel.login()) {
                    //Toast.makeText(this, "Valid", Toast.LENGTH_LONG).show()
                    val signIn: Button = findViewById(R.id.SignIn)
                    signIn.setOnClickListener {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}