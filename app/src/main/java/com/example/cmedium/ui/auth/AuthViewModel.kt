package com.example.cmedium.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.User
import com.example.cmedium.data.UserRepi
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel(){

    private val _user = MutableLiveData<User?>()

    val user: LiveData<User?> = _user

    fun login(email: String, password: String) = viewModelScope.launch {
        UserRepi.login(email,password)?.let {
            _user.postValue(it)
        }

    }

    fun signup(username: String, email: String, password: String) = viewModelScope.launch {
        UserRepi.signup(username,email,password)?.let {
            _user.postValue(it)
        }
    }
}