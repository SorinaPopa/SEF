package com.example.stadevents.home.addevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.stadevents.R
import com.example.stadevents.databinding.AddEventDialogBinding

class AddEventDialogFragment : DialogFragment() {
    private lateinit var binding: AddEventDialogBinding
    private val addEventViewModel: AddEventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddEventDialogBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.addEventViewModel = addEventViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateDialogFeatures()
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        addEventViewModel.onClickSavedButton.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                val action = AddEventDialogFragmentDirections.actionAddEventDialogToHomeFragment(addEventViewModel.getEvent())
                findNavController().navigate(action)
                addEventViewModel.onClickSavedButton.value = false
            }
        }
        addEventViewModel.onClickCancelButton.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_addEventDialog_to_homeFragment)
                addEventViewModel.onClickCancelButton.value = false
            }
        }
    }

    private fun updateDialogFeatures() {
        requireDialog().window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
    }

}