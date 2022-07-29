package com.michaelbruno.tech.nectar

sealed class Screen(val route:String){
    object SplashScreen:Screen("splash_screen")
    object OnBoardingScreen:Screen("on_boarding_screen")
    object SignIn:Screen("sign_in_screen")
    object SignUp:Screen("sign_up_screen")
}