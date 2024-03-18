package com.example.zedtask

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayData : AppCompatActivity() {
    private lateinit var description: TextView
    private lateinit var amount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        description = findViewById<TextView>(R.id.outDescription)
        amount = findViewById<TextView>(R.id.outAmount)

        val resultDescription = "Description: " + intent.getStringExtra("description")
        val resultAmount = "Amount: " + intent.getStringExtra("amount")

        description.text = resultDescription
        amount.text = resultAmount
    }
}