package com.example.cmedium.data

import com.example.api.CmediumClient
import com.example.api.models.entities.LoginData
import com.example.api.models.requests.LoginRequest
import com.example.api.models.responses.UserResponse

object UserRepi {

    val api = CmediumClient().api

    suspend fun login(email: String, password: String): UserResponse? {
       val response = api.loginUser(LoginRequest(LoginData(email,password)))
        return response.body()
    }
}