package com.example.zedtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.setting_activity)

        val userName = intent.getStringExtra("name")
        val userEmail = intent.getStringExtra("email")

        val uName = findViewById<TextView>(R.id.nameText)
        val uEmail = findViewById<TextView>(R.id.emailText)

        uName.text = userName
        uEmail.text = userEmail

        val signOutButton = findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }


}
