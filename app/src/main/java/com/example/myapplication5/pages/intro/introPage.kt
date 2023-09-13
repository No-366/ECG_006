package com.example.myapplication5.pages.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.os.Looper
import com.example.myapplication5.R

class introPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@introPage, Startpage()::class.java)
            startActivity(intent)
            finish()
        }, 1500)

    }
}

