package com.example.stadevents.register

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.example.stadevents.R
import com.example.stadevents.databinding.LoginActivityBinding
import com.example.stadevents.databinding.RegisterActivityBinding
import com.example.stadevents.login.LoginActivity
import com.example.stadevents.login.LoginActivity.Companion.IS_ORGANISER
import com.example.stadevents.login.LoginViewModel
import com.example.stadevents.register.newuser.NewUser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: RegisterActivityBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.registerViewModel = registerViewModel
        setContentView(binding.root)
        supportActionBar?.hide()
        subscribeToObserver()
        getNewUserData()
        saveNewUserData()
    }

    private fun saveNewUserData() {
        val editor = sharedPreferences.edit()
        editor.putString(IS_ORGANISER, registerViewModel.name.value)
        editor.putString(IS_ORGANISER, registerViewModel.username.value)
        editor.putString(IS_ORGANISER, registerViewModel.email.value)
        editor.putString(IS_ORGANISER, registerViewModel.password.value) //encript
        editor.putString(IS_ORGANISER, registerViewModel.validationCode.value)
        editor.apply()
    }

    private fun getNewUserData() {
        //get event list from shared preferences
        //and save it to registerViewModel.eventList
    }

    private fun subscribeToObserver() {
        registerViewModel.onRegisterClicked.observe(this) { value ->
            if (value) {
                if (registerViewModel.register()) {
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}