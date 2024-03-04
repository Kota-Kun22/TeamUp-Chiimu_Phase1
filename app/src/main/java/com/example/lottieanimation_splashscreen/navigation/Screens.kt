package com.example.lottieanimation_splashscreen.navigation
sealed class Screens(val route: String) {
    object SignInScreen : Screens(route = "SignIn_Screen")
    object SignUpScreen : Screens(route = "SignUp_Screen")
    object HomeScreen : Screens(route = "Home_Screen")
    object  OnBoardingScreen : Screens(route = "OnBoardingScreen")
    object  SplashScreen : Screens(route = "SplashScreen")
}
