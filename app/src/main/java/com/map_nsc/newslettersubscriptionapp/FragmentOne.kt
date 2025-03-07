package com.map_nsc.newslettersubscriptionapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.map_nsc.newslettersubscriptionapp.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the binding for FragmentOne
        binding = FragmentOneBinding.inflate(inflater, container, false)

        // Set the listener for the Register button
        binding.registerButton.setOnClickListener {
            handleRegistration()
        }

        return binding.root
    }

    private fun handleRegistration() {
        // Retrieve user inputs
        val name = binding.editTextName.text.toString()
        val email = binding.editTextEmail.text.toString()
        val selectedGenderId = binding.radioGroupGender.checkedRadioButtonId
        val gender = when (selectedGenderId) {
            R.id.radioMale -> "Male"
            R.id.radioFemale -> "Female"
            R.id.radioOther -> "Other"
            else -> "Not specified"
        }
        val termsAgreed = binding.checkBoxTerms.isChecked
        val familyEmailsOptIn = binding.switchFamilyEvents.isChecked

        // Check if terms and conditions are agreed
        if (!termsAgreed) {
            Toast.makeText(requireContext(), "You must agree to the terms and conditions", Toast.LENGTH_LONG).show()
            return
        }

        // Creating a bundle to pass data to FragmentTwo
        val bundle = Bundle().apply {
            putString("name", name)
            putString("email", email)
            putString("gender", gender)
            putBoolean("termsAgreed", termsAgreed)
            putBoolean("familyEmails", familyEmailsOptIn)
        }

        // Create FragmentTwo and pass the bundle
        val fragmentTwo = FragmentTwo()
        fragmentTwo.arguments = bundle

        // Perform fragment transaction
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentTwo)
            .addToBackStack(null)
            .commit()
    }
}
