package com.example.zedtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {

    private lateinit var btnSignUp: Button
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

/*        btnSignUp = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }*/
        btnSignUp = findViewById(R.id.btnSignUp)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.rePassword)

        btnSignUp.setOnClickListener{
            // Here we need to check if the password and confirm password are the same
            // But not implemented it, because it is not in the scope of the task
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("name", name.text.toString())
            intent.putExtra("email", email.text.toString())

            startActivity(intent)
        }
    }
}