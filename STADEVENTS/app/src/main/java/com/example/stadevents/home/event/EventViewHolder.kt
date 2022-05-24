package com.example.stadevents.home.event

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.stadevents.databinding.CardLayoutBinding


class EventViewHolder(private var binding: CardLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(event: Event) {
        binding.eventImage.setImageResource(event.image)
        binding.eventTitle.text = event.title
        binding.eventSubtitle.text = event.subtitle
        setOnBuyClickListener(event)
    }

    private fun setOnBuyClickListener(event: Event) {
        binding.buyButton.setOnClickListener {
            Toast.makeText(
                itemView.context,
                "${event.title} has been bought!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}