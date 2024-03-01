package com.example.lottieanimation_splashscreen.data

import com.google.firebase.auth.AuthResult
import com.example.lottieanimation_splashscreen.util.Resources
import kotlinx.coroutines.flow.Flow

interface AuthRepo  {
    fun loginUser(email: String, password: String): Flow<Resources<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resources<AuthResult>>
}
