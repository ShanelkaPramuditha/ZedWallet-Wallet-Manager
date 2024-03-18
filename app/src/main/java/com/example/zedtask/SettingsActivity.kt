package com.example.zedtask

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.setting_activity)

        // Initialize views
        nameTextView = findViewById(R.id.nameText)
        emailTextView = findViewById(R.id.emailText)

        // Get the values from the intent extras
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        // Set the values to the respective TextViews in SettingsActivity
        nameTextView.text = name
        emailTextView.text = email
    }
}
