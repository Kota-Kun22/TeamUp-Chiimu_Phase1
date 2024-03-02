package com.example.lottieanimation_splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lottieanimation_splashscreen.HomeScreen
import com.example.lottieanimation_splashscreen.presentation.SignInScreen
import com.example.lottieanimation_splashscreen.presentation.SignUpScreen
import com.example.lottieanimation_splashscreen.presentation.SignUpState
import com.example.lottieanimation_splashscreen.presentation.SignUpViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screens.SignUpScreen.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }

        composable(route = Screens.SignInScreen.route) {

        }
        composable(route = Screens.SignUpScreen.route) {
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(
                viewModel = viewModel,
                state = SignUpState()
            )
        }


    }

}
