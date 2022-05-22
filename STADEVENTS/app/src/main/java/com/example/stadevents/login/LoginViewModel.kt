package com.example.stadevents.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stadevents.login.business.UserMapper

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val name = MutableLiveData("")
    val password = MutableLiveData("")
    val onLoginButtonClicked = MutableLiveData(false)

    fun login(): Boolean {
        val userList = UserMapper.getUsersList()
        for (user in userList) {
            if (user.name == name.value && user.password == password.value) {
                return true
            }
        }
        return false
    }

    fun onClickLoginButton() {
        onLoginButtonClicked.value = true
    }
}