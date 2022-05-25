package com.example.stadevents.login.business

data class User(
    val name: String,
    val password: String,
    val validationCode: String
)