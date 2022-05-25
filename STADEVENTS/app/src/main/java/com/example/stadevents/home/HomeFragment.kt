package com.example.stadevents.home

import android.content.Context
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
import com.example.stadevents.login.LoginActivity

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
        getUserRole()
        homeViewModel.addEvent(args.event)
        return binding.root
    }

    private fun getUserRole() {
        val sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )
        val isOrganiser = sharedPreferences.getBoolean(LoginActivity.IS_ORGANISER, false)
        homeViewModel.isOrganiser.value = isOrganiser
    }

    private fun getEventList() {
        //get event list from shared preferences
        //and save it to HomeViewModel.eventList
        val sharedPreferencesEvent = requireActivity().getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )
//        val gson = Gson()
//        val json = sharedPreferencesEvent.getString("event list",null)
//        val type = TypeToken<ArrayList<Event>>() {}.type
//        Gson gson = new Gson();
//        String json = sharedPreferencesEvent.getString("event list",null);
//        Type type = new TypeToken<ArrayList<Event>>() {}.getType();
//        eventList=gson.fromJson(json,type);
//
//        if(eventList==null){
//            eventList=new ArrayList<>();
//        }

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
        val sharedPreferencesEvent = activity?.getSharedPreferences(
            getString(R.string.shared_preference_organiser), Context.MODE_PRIVATE
        )

//
//        SharedPreferences.Editor editor = sharedPreferencesEvent.edit();
//        Gson gson=new Gson();
//        String json=gson.toJson(eventList);
//        editor.putString("event list",json);
//        editor.apply;
    }

}