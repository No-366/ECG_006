package com.example.myapplication5.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication5.databinding.ActivityMainBinding
import com.example.myapplication5.models.Login_Model
import com.example.myapplication5.models.SignUp_Model
import com.example.myapplication5.service.networkService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import android.content.Context
import android.content.SharedPreferences



class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    // SharedPreferences 초기화
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences 초기화
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        binding.loginButton.setOnClickListener {
            val userIdText = binding.userid.text.toString()
            val userpassword = binding.userpw.text.toString()
            var model = Login_Model(userIdText, userpassword)



            if (userIdText.isNotEmpty() && userpassword.isNotEmpty()) {

                val userIdCall = networkService.login(model)

                userIdCall.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            // 서버에서 JWT 토큰을 받아옴
                            val jwtToken = response.headers()["Authorization"]
                            if (!jwtToken.isNullOrBlank()) {
                                // SharedPreferences에 저장
                                sharedPrefs.edit().putString("jwtToken", jwtToken).apply()
                                println("JWT 토큰 저장 성공")
                            } else {
                                println("JWT 토큰이 없습니다.")
                            }
                            // 요청이 성공적으로 처리됨
                            println("아이디 전송 성공")
                        } else {
                            // 요청이 실패한 경우
                            println("요청 실패: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        // 통신 실패 시
                        println("통신 실패: ${t.message}")
                    }
                })
            } else {
                // userIdText 또는 userpassword가 비어있는 경우에 대한 처리를 여기에 추가
                println("아이디 또는 비밀번호를 입력해주세요.")
            }
        }

        binding.signUpButton.setOnClickListener {
            val userIdText = binding.userid.text.toString()
            val emailText = binding.email.text.toString()
            val userpwText = binding.userpw.text.toString()
            val nameText = binding.name.text.toString()
            val schoolNameText = binding.schoolname.text.toString()
            val rolesText = binding.roles.text.toString()
            var model = SignUp_Model(userIdText,emailText,userpwText,nameText,schoolNameText,rolesText)



            if (userIdText.isNotEmpty() && emailText.isNotEmpty()&& userpwText.isNotEmpty()&& nameText.isNotEmpty()&& schoolNameText.isNotEmpty()&& rolesText.isNotEmpty()) {

                val userIdCall = networkService.signup(model)

                userIdCall.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            // 요청이 성공적으로 처리됨
                            println("회원가입 성공")
                        } else {
                            // 요청이 실패한 경우
                            println("요청 실패: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        // 통신 실패 시
                        println("통신 실패: ${t.message}")
                    }
                })
            } else {
                // userIdText 또는 userpassword가 비어있는 경우에 대한 처리를 여기에 추가
                println("모든 정보를 입력해주세요.")
            }
        }
    }
}
