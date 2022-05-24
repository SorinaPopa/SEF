package com.example.stadevents.home.addevent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddEventViewModel : ViewModel() {
    val editTextTitle = MutableLiveData<String>()
    val editTextSubtitle = MutableLiveData<String>()
    val onClickSavedButton = MutableLiveData(false)
    val onClickCancelButton = MutableLiveData(false)

    fun onSaveButtonClicked() {
        onClickSavedButton.value = true
    }

    fun onCancelButtonClicked() {
        onClickCancelButton.value = true
    }
}