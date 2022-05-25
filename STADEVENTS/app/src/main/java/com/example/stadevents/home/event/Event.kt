package com.example.stadevents.home.event

import java.io.Serializable

data class Event(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: Int
) : Serializable