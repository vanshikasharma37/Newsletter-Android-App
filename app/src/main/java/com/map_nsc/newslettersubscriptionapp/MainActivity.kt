package com.map_nsc.newslettersubscriptionapp

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.map_nsc.newslettersubscriptionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set background only for MainActivity
        binding.root.setBackgroundResource(R.drawable.main)

        // Start button click navigates to FragmentOne
        binding.startSubscriptionButton.setOnClickListener {
            openFragmentOne()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                handleBackPress()
            }
        })
    }

    private fun openFragmentOne() {
        // Hide MainActivity UI elements
        binding.appTitle.visibility = View.GONE
        binding.welcomeMessage.visibility = View.GONE
        binding.startSubscriptionButton.visibility = View.GONE

        // Remove background when navigating to FragmentOne
        binding.root.setBackgroundResource(0)

        supportFragmentManager.commit {
            replace(R.id.fragment_container, FragmentOne())
            addToBackStack(null) // Allow user to go back
        }
    }

    private fun handleBackPress() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            // Restore the background and UI elements
            binding.root.setBackgroundResource(R.drawable.main)
            binding.appTitle.visibility = View.VISIBLE
            binding.welcomeMessage.visibility = View.VISIBLE
            binding.startSubscriptionButton.visibility = View.VISIBLE
            finish() // Close the activity if no fragments are left
        }
    }
}
