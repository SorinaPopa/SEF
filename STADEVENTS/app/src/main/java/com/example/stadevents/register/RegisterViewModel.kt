package com.example.stadevents.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stadevents.home.event.Event
import com.example.stadevents.register.newuser.NewUser

class RegisterViewModel : ViewModel() {
    val name = MutableLiveData("")
    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val validationCode = MutableLiveData("")
    val onRegisterClicked = MutableLiveData(false)
    val newUserList = MutableLiveData<List<NewUser>>(emptyList())

    fun register(): Boolean {
        //verifies that the data added doesn't repeat
        //saves the data added
        return false
    }

    fun onClickRegisterButton() {
        onRegisterClicked.value = true
    }

    fun addNewUser(newUser: NewUser?) {
        if(newUser!=null) {
            val newNewUserList = newUserList.value?.plus(newUser)
            newUserList.value = newNewUserList!!
        }
    }
}