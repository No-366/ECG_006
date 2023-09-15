package com.example.myapplication5.pages.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication5.databinding.ActivitySignUpBinding
import com.example.myapplication5.models.Response_Model
import com.example.myapplication5.models.SignUp_Model
import com.example.myapplication5.service.networkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signUpButton.setOnClickListener {
            val userIdText = binding.userid.text.toString()
            val emailText = binding.email.text.toString()
            val userpwText = binding.userpw.text.toString()
            val nameText = binding.name.text.toString()
            val schoolNameText = binding.schoolname.text.toString()
            val rolesText = listOf("user")
            var model = SignUp_Model(userIdText,emailText,userpwText,nameText,schoolNameText,rolesText)



            if (userIdText.isNotEmpty() && emailText.isNotEmpty()&& userpwText.isNotEmpty()&& nameText.isNotEmpty()&& schoolNameText.isNotEmpty()&& rolesText.isNotEmpty()) {

                val userIdCall = networkService.signup(model)

                userIdCall.enqueue(object : Callback<Response_Model> {
                    override fun onResponse(call: Call<Response_Model>, response: Response<Response_Model>) {
                        if (response.isSuccessful) {
                            // 요청이 성공적으로 처리됨
                            println("회원가입 성공")
                            println("${response.body()}")
                            Toast.makeText(applicationContext, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                        } else {
                            // 요청이 실패한 경우
                            println("요청 실패: ${response.code()}, ${response.message()}")
                            Toast.makeText(applicationContext, "이미 등록된 회원입니다!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Response_Model>, t: Throwable) {
                        // 통신 실패 시
                        println("통신 실패: ${t.message}")
                        Toast.makeText(applicationContext, "인터넷연결을 확인해주세요", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                // 공란이 있을 경우
                println("모든 정보를 입력해주세요.")
                Toast.makeText(applicationContext, "모든 정보를 입력해 주세요!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}