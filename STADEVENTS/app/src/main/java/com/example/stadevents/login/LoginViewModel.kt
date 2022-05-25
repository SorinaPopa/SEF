package com.example.stadevents.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stadevents.login.business.UserMapper

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val name = MutableLiveData("")
    val password = MutableLiveData("")
    val validationCode = MutableLiveData("")
    val onLoginButtonClicked = MutableLiveData(false)
    val onOrganiserChecked = MutableLiveData(false)
    val onRegisterHereClicked = MutableLiveData(false)
    private val userList = UserMapper.getUsersList()

    fun isUserValid(): Boolean {
        for (user in userList) {
            if (user.name == name.value && user.password == password.value && user.validationCode == validationCode.value) {
                return true
            }
        }
        return false
    }

    fun isOrganiserCodeValid(): Boolean {
        for (user in userList) {
            if (user.validationCode == validationCode.value && user.validationCode != "") {
                return true
            }
        }
        return false
    }

    fun onClickLoginButton() {
        onLoginButtonClicked.value = true
    }

    fun onClickOrganiserCheckBox(isChecked: Boolean) {
        onOrganiserChecked.value = isChecked
    }

    fun onClickRegisterHereButton() {
        onRegisterHereClicked.value = true
    }
}