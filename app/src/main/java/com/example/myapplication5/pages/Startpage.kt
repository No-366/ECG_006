package com.example.myapplication5.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication5.R
import com.example.myapplication5.databinding.ActivityStartpageBinding

class Startpage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startpage)

        val binding = ActivityStartpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.StartButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}