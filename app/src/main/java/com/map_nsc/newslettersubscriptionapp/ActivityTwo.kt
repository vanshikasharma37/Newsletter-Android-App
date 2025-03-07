package com.map_nsc.newslettersubscriptionapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.map_nsc.newslettersubscriptionapp.databinding.ActivityTwoBinding

class ActivityTwo : AppCompatActivity() {

    private lateinit var binding: ActivityTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the user's name from the intent
        val userName = intent.getStringExtra("userName") ?: "User"

        // Set the welcome message dynamically
        binding.welcomeTextView.text = "Hello, $userName!\n\nWelcome to Activity Two\nWe’re excited to have you!"

        // Styling the message
        binding.welcomeTextView.setPadding(32, 32, 32, 32)
        binding.welcomeTextView.textSize = 24f
        binding.welcomeTextView.setTextColor(ContextCompat.getColor(this, R.color.white))

        // Ensure yellow background is applied
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))

        // Ensure the icon remains hidden unless required
        binding.iconImageView?.visibility = View.GONE

        // Set button click to navigate back
        binding.backToFragmentButton.setOnClickListener {
            finish() // This will close ActivityTwo and go back
        }
    }
}
