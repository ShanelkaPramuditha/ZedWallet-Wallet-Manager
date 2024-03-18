package com.example.zedtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IncomeActivity : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var inputDescription: EditText
    private lateinit var inputAmount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.income_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAdd = findViewById(R.id.btnAdd)

        inputDescription = findViewById(R.id.inputDescription)
        inputAmount = findViewById(R.id.inputAmount)

        btnAdd.setOnClickListener{
            val intent = Intent(this, DisplayData::class.java)

            intent.putExtra("description", inputDescription.text.toString())
            intent.putExtra("amount", inputAmount.text.toString())

            startActivity(intent)
        }
    }
}