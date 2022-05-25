package com.example.stadevents.announcements

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnnouncementViewModel : ViewModel() {
    val fabAnnouncementClicked = MutableLiveData(false)
    val isOrganiser = MutableLiveData(false)

    fun onFABAnnouncementClicked() {
        fabAnnouncementClicked.value = true
    }

//    fun addAnnouncement(){
//
//    }
}