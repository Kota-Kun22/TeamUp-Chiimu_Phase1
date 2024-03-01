package com.example.lottieanimation_splashscreen.di

import com.example.lottieanimation_splashscreen.data.AuthRepo
import com.example.lottieanimation_splashscreen.data.AuthRepoImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesAuthRepo(firebaseAuth: FirebaseAuth): AuthRepo = AuthRepoImpl(firebaseAuth)
}
