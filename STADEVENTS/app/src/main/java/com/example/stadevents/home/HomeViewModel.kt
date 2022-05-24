package com.example.stadevents.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stadevents.R
import com.example.stadevents.home.event.Event

class HomeViewModel : ViewModel() {
    val eventList = MutableLiveData<List<Event>>(emptyList())
    val fabClicked = MutableLiveData(false)

    fun initList() {
        var list = emptyList<Event>()
        for (i in 1..5) {
            list = list + Event(i,"Title", "Subtitle", R.drawable.ic_football)
        }
        eventList.value=list
    }
    fun onFABClicked() {
        fabClicked.value = true
    }
}