package com.example.stadevents.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.stadevents.R
import com.example.stadevents.databinding.LoginActivityBinding
import com.example.stadevents.databinding.RegisterActivityBinding
import com.example.stadevents.login.LoginActivity
import com.example.stadevents.login.LoginViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: RegisterActivityBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.registerViewModel = registerViewModel
        setContentView(binding.root)
        supportActionBar?.hide()
        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        registerViewModel.onRegisterClicked.observe(this) { value ->
            if (value) {
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
            }
        }
    }
}