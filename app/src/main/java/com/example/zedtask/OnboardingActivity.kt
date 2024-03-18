package com.example.zedtask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class OnboardingActivity: AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var adapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val layouts = intArrayOf(
            R.layout.onboarding_activity_1,
            R.layout.onboarding_activity_2,
            R.layout.onboarding_activity_3
        )

        viewPager = findViewById(R.id.viewPager)
        adapter = OnboardingAdapter(this, layouts)
        viewPager.adapter = adapter
        var current = viewPager.currentItem

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            current += 1
            //updateButtonVisibility(viewPager.currentItem)
            Log.d("OnboardingActivity", "Current: $current")
            if (current < layouts.size) {
                viewPager.currentItem = current
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {

            //updateButtonVisibility(viewPager.currentItem)
            Log.d("OnboardingActivity", "Current: $current")
            if (current >= 0) {
                current -= 1
                viewPager.currentItem = current
            }
        }

        val btnSkip = findViewById<Button>(R.id.btnSkip)
        btnSkip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //updateButtonVisibility(viewPager.currentItem)
    }

    private fun updateButtonVisibility(currentItem: Int) {
        val btnBack = findViewById<Button>(R.id.btnBack)
        val current = currentItem + 1
        Log.d("OnboardingActivity", "CurrentItem: $current")
        btnBack.visibility = if (current == 1) {
            Button.INVISIBLE
        } else {
            Button.VISIBLE
        }
    }
}