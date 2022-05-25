package com.example.stadevents.announcements

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.stadevents.R
import com.example.stadevents.databinding.AnnouncementFragmentBinding
import com.example.stadevents.home.HomeViewModel
import com.example.stadevents.login.LoginActivity


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
        getUserRole()
        return binding.root
    }

    private fun getUserRole() {
        val sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )
        val isOrganiser = sharedPreferences.getBoolean(LoginActivity.IS_ORGANISER, false)
        announcementViewModel.isOrganiser.value = isOrganiser
    }
}