package com.example.lottieanimation_splashscreen.data

import com.example.lottieanimation_splashscreen.util.Resources
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) : AuthRepo {
    override fun loginUser(email: String, password: String): Flow<Resources<AuthResult>> {
        return flow {
            emit(Resources.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resources.Success(result))
        }.catch {
            emit(Resources.Error(it.message.toString()))
        }
    }

    // Implementing the registerUser method
    override fun registerUser(email: String, password: String): Flow<Resources<AuthResult>> {
        return flow {
            emit(Resources.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(Resources.Success(result))
        }.catch {
            emit(Resources.Error(it.message.toString()))
        }
    }
}
