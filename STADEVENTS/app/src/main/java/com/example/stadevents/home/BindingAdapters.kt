package com.example.stadevents.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stadevents.home.event.Event
import com.example.stadevents.home.event.EventListAdapter


@BindingAdapter("homeItems")
fun bindHomeRecyclerView(view: RecyclerView, itemList: List<Event>) {
    val adapter = EventListAdapter()
    adapter.submitList(itemList)
    view.adapter = adapter

}