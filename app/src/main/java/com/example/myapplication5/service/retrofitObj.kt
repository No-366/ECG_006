package com.example.myapplication5.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit
    get() = Retrofit.Builder()
        .baseUrl("http://43.202.65.29:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

var networkService: service_interface = retrofit.create(service_interface::class.java)