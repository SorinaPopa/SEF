package com.example.stadevents.register.newuser

import androidx.lifecycle.MutableLiveData

data class NewUser(
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val validationCode: String
)