package com.example.stadevents.announcements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.stadevents.R
import com.example.stadevents.databinding.AnnouncementFragmentBinding
import com.example.stadevents.home.HomeViewModel


class AnnouncementFragment : Fragment() {
    private lateinit var binding: AnnouncementFragmentBinding
    private val announcementViewModel: AnnouncementViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= AnnouncementFragmentBinding.inflate(inflater,container,false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.announcementViewModel=announcementViewModel
        //announcementViewModel.addAnnouncement(args.announcement)
        return binding.root
    }
}