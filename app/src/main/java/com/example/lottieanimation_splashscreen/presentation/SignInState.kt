package com.example.lottieanimation_splashscreen.presentation

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String = "",
    val isError: String? = null
)
