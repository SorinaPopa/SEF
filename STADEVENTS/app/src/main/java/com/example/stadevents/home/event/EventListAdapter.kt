package com.example.stadevents.home.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stadevents.R

class EventListAdapter: RecyclerView.Adapter<EventListAdapter.ViewHolder>() {
    private var titles =
        arrayOf(
            "First Event",
            "Second Event",
            "Third Event",
            "Forth Event",
            "Fifth Event",
            "Sixth Event",
            "Seventh Event",
            "Eight Event"
        )
    private var details = arrayOf(
        "Event One Details",
        "Event Two Details",
        "Event Three Details",
        "Event Four Details",
        "Event Five Details",
        "Event Six Details",
        "Event Seven Details",
        "Event Eight Details"
    )
    private var images = intArrayOf(
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football,
        R.drawable.ic_football
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: EventListAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.eventImage)
            itemTitle = itemView.findViewById(R.id.eventTitle)
            itemDetail = itemView.findViewById(R.id.eventSubtitle)
        }
    }
}