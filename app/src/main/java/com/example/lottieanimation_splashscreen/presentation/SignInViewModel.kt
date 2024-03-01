package com.example.lottieanimation_splashscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lottieanimation_splashscreen.data.AuthRepo
import com.example.lottieanimation_splashscreen.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {
    private val _signInState = Channel<Resources<SignInState>>()
    val signInState = _signInState.receiveAsFlow()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _signInState.send(Resources.Loading())
            repo.loginUser(email, password).collect { result ->
                when (result) {
                    is Resources.Success -> {
                        _signInState.send(Resources.Success(SignInState(isSuccess = "Sign In Success")))
                    }
                    is Resources.Error -> {
                        _signInState.send(Resources.Error(message = result.message ?: "An error occurred"))
                    }


                    is Resources.Loading -> {
                        _signInState.send(Resources.Loading())
                    }
                }
            }
        }
    }
}
