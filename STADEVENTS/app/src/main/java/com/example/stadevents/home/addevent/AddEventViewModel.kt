package com.example.stadevents.home.addevent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stadevents.R
import com.example.stadevents.home.event.Event

class AddEventViewModel : ViewModel() {
    val editTextTitle = MutableLiveData("")
    val editTextSubtitle = MutableLiveData("")
    val onClickSavedButton = MutableLiveData(false)
    val onClickCancelButton = MutableLiveData(false)

    fun onSaveButtonClicked() {
        onClickSavedButton.value = true
    }

    fun onCancelButtonClicked() {
        onClickCancelButton.value = true
    }

    fun getEvent() =
        Event(
            8,
            editTextTitle.value!!,
            editTextSubtitle.value!!,
            R.drawable.ic_football
        )
}