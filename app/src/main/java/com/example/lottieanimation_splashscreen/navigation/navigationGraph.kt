package com.example.lottieanimation_splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lottieanimation_splashscreen.HomeScreen
import com.example.lottieanimation_splashscreen.MainActivity
import com.example.lottieanimation_splashscreen.OnboardingScreen
import com.example.lottieanimation_splashscreen.SplashScreen
import com.example.lottieanimation_splashscreen.presentation.SignInScreen
import com.example.lottieanimation_splashscreen.presentation.SignInState
import com.example.lottieanimation_splashscreen.presentation.SignInViewModel
import com.example.lottieanimation_splashscreen.presentation.SignUpScreen
import com.example.lottieanimation_splashscreen.presentation.SignUpState
import com.example.lottieanimation_splashscreen.presentation.SignUpViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }

        composable(route = Screens.OnBoardingScreen.route) {
            OnboardingScreen(navController = navController, context = MainActivity())
        }

        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController, context = MainActivity())

//            LaunchedEffect(true) {
//                delay(5000)
//                navController.navigate(Screens.OnBoardingScreen.route) {
//                    popUpTo(Screens.SplashScreen.route) {inclusive = true}
//                }
//            }
        }
        composable(route = Screens.SignUpScreen.route) {
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(
                viewModel = viewModel,
                state = SignUpState()
            )
        }

        composable(route = Screens.SignInScreen.route) {
            val viewModel: SignInViewModel = hiltViewModel()
            SignInScreen(
                viewModel = viewModel,
                state = SignInState())
        }


    }

}
