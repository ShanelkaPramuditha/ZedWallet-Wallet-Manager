package com.example.zedtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSettings = findViewById<ExtendedFloatingActionButton>(R.id.btnSettings)
        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        val btnIncome = findViewById<ExtendedFloatingActionButton>(R.id.btnIncome)
        btnIncome.setOnClickListener {
            startActivity(Intent(this, IncomeActivity::class.java))
        }

        val btnExpense = findViewById<ExtendedFloatingActionButton>(R.id.btnExpense)
        btnExpense.setOnClickListener {
            startActivity(Intent(this, ExpenseActiv::class.java))
        }
    }
}