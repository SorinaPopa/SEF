package com.example.stadevents.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val onRegisterClicked = MutableLiveData(false)

    fun onClickRegisterButton(){
        onRegisterClicked.value = true
    }
}