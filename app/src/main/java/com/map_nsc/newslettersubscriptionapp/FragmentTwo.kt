package com.map_nsc.newslettersubscriptionapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.map_nsc.newslettersubscriptionapp.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTwoBinding.inflate(inflater, container, false)

        // Retrieve data passed from FragmentOne via Bundle
        val name = arguments?.getString("name") ?: "User"
        val email = arguments?.getString("email") ?: "No Email"
        val gender = arguments?.getString("gender") ?: "Not specified"
        val agreedToTerms = arguments?.getBoolean("termsAgreed") ?: false
        val familyEventOptIn = arguments?.getBoolean("familyEmails") ?: false

        // Populate TextViews with received data
        binding.thankYouTextView.text = "Thank you for subscribing!"
        binding.userInfoTextView.text = "Name: $name\nEmail: $email\nGender: $gender"
        binding.agreementStatusTextView.text = "Agreed to Terms: ${if (agreedToTerms) "Yes" else "No"}"
        binding.familyEventStatusTextView.text = "Opted-in for Family Events: ${if (familyEventOptIn) "Yes" else "No"}"

        // **Back to Subscription Form Button**
        binding.backToFormButton.setOnClickListener {
            // Replace FragmentTwo with FragmentOne when the back button is pressed
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentOne())
                .addToBackStack(null)  // Allows user to go back
                .commit()
        }

        // **Go to ActivityTwo Button**
        binding.goToActivityTwoButton.setOnClickListener {
            // Navigate to ActivityTwo with the user’s name
            val intent = Intent(requireContext(), ActivityTwo::class.java)
            intent.putExtra("userName", name)
            startActivity(intent)
        }

        return binding.root
    }
}
