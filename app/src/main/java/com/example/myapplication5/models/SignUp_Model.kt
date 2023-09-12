package com.example.myapplication5.models

data class SignUp_Model(
    private val username: String,
    private val email: String,
    private val password: String,
    private val name: String,
    private val schoolName: String,
    private val roles: List<String> //코틀린 리스트 공부
)