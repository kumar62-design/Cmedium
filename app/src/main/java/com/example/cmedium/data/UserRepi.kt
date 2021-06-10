package com.example.cmedium.data

import com.example.api.CmediumClient
import com.example.api.models.entities.LoginData
import com.example.api.models.entities.SignupData
import com.example.api.models.entities.User
import com.example.api.models.requests.LoginRequest
import com.example.api.models.requests.SignupRequest
import com.example.api.models.responses.UserResponse

object UserRepi {

    val api = CmediumClient.publicApi
    val authAPI = CmediumClient.authApi


    // This code is login
     suspend fun login(email: String, password: String): User? {
       val response = api.loginUser(LoginRequest(LoginData(email,password)))

        CmediumClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    // This code is for signup
    suspend fun signup(username:String, email:String, password: String):User?{
        val response = api.signupUser(SignupRequest(SignupData(
            email,password,username
        )))
        CmediumClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

       // This is for get user profile
    suspend fun getUserProfile() = authAPI.getCurrentUser().body()?.user
}