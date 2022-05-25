package com.example.stadevents.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.stadevents.R
import com.example.stadevents.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private val args by navArgs<HomeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
        getEventList()
        homeViewModel.addEvent(args.event)
        return binding.root
    }

    private fun getEventList() {
        //get event list from shared preferences
        //and save it to HomeViewModel.eventList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        homeViewModel.fabClicked.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_homeFragment_to_addEventDialog)
                homeViewModel.fabClicked.value = false
            }

        }
    }

    private fun saveEventList() {
        //save event list to shared preferences
    }

}