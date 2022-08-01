package com.michaelbruno.tech.nectar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelbruno.tech.nectar.presentation.screens.OnBoardingScreen
import com.michaelbruno.tech.nectar.presentation.screens.SignInWithEmailAndPasswordScreen
import com.michaelbruno.tech.nectar.presentation.screens.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.OnBoardingScreen.route){
            OnBoardingScreen(navController = navController)
        }
        composable(route=Screen.SignInWithEmailAndPasswordScreen.route){
            SignInWithEmailAndPasswordScreen(navController=navController)
        }
    }

}