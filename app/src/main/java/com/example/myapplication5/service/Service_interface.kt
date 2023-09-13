package com.example.myapplication5.service

import com.example.myapplication5.models.Login_Model
import com.example.myapplication5.models.Response_Model
import com.example.myapplication5.models.SignUp_Model
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface service_interface {//Retrofit을 사용하여 HTTP 요청을 정의하는 인터페이스
    @POST("/api/auth/signin") //적절한 엔드포인트 지정
    fun login(@Body model: Login_Model): Call<Response_Model>

    @POST("/api/auth/signup")
    fun signup(@Body model: SignUp_Model): Call<Response_Model>
}

