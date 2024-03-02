package com.example.lottieanimation_splashscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lottieanimation_splashscreen.navigation.NavigationGraph
import com.example.lottieanimation_splashscreen.presentation.SignUpScreen
import com.example.lottieanimation_splashscreen.ui.theme.LottieAnimation_splashScreenTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationGraph()
        }
    }
}


//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LottieAnimation_splashScreenTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "Splash" )
//                    {
//                        composable("Splash"){
//                            SplashScreen(navController=navController, context = this@MainActivity)
//                        }
//                        composable("Onboarding"){
//                            OnboardingScreen(navController= navController, context = this@MainActivity)
//                        }
//                        composable("Home"){
//                            HomeScreen()
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//}

