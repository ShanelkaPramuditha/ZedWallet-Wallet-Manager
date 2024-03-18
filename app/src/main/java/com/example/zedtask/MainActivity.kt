package com.example.zedtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Get Data */
        name = findViewById<TextView>(R.id.welcome)

        val nameWelcome = "Hi!, " + intent.getStringExtra("name")

        name.text = nameWelcome

        /* Button Clicks */
        val btnSettings = findViewById<ExtendedFloatingActionButton>(R.id.btnSettings)
        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            //startActivity(Intent(this, SettingsActivity::class.java))
            intent.putExtra("name", name.text.toString())
            intent.putExtra("email", intent.getStringExtra("email"))
            startActivity(intent)
        }

        val btnIncome = findViewById<ExtendedFloatingActionButton>(R.id.btnIncome)
        btnIncome.setOnClickListener {
            startActivity(Intent(this, IncomeActivity::class.java))
        }

        val btnExpense = findViewById<ExtendedFloatingActionButton>(R.id.btnExpense)
        btnExpense.setOnClickListener {
            startActivity(Intent(this, ExpenseActivity::class.java))
        }

        val btnStats = findViewById<ExtendedFloatingActionButton>(R.id.btnStats)
        btnStats.setOnClickListener {
            startActivity(Intent(this, StatsActivity::class.java))
        }
    }
}