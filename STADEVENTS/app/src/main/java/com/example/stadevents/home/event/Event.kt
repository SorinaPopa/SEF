package com.example.stadevents.home.event

import java.io.Serializable

class Event(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: Int
) : Serializable