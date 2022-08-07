package com.michaelbruno.tech.nectar

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object OnBoardingScreen : Screen("on_boarding_screen")
    object SignInWithGoogleScreen : Screen("sign_in_with_google_screen")
    object SignUpWithGoogleScreen : Screen("sign_up_with_google_screen")
    object SignInWithEmailAndPasswordScreen : Screen("sign_in_with_email_and_password_screen")
    object SignUpWithEmailAndPasswordScreen : Screen("sign_up_with_email_and_password_screen")
    object HomeScreen : Screen("home_screen")
    object ExploreScreen : Screen("explore_screen")
    object CartScreen : Screen("explore_screen")
    object FavouritesScreen : Screen("explore_screen")
    object ProfileScreen : Screen("profile_screen")
}