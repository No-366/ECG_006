package com.example.myapplication5.pages


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.Bluetooth.testActivity
import com.example.myapplication5.Bluetooth.testActivity2

import com.example.myapplication5.R
import com.example.myapplication5.databinding.ActivityMypageBinding


class Mypage : AppCompatActivity() {
    private lateinit var binding: ActivityMypageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        // 뷰 바인딩 초기화
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namedata = intent.getStringExtra("namedata")
        binding.textView2.text = "안녕하세요, "+namedata+"님"

       binding.button3.setOnClickListener{
           val intent: Intent = Intent(this, testActivity2::class.java)
           startActivity(intent)
       }


    }
}