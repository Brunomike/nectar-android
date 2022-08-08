package com.michaelbruno.tech.nectar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelbruno.tech.nectar.presentation.screens.*

@Composable
fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(route = Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(route = Screen.OnBoardingScreen.route) {
                OnBoardingScreen(navController = navController)
            }
            composable(route = Screen.SignInWithEmailAndPasswordScreen.route) {
                SignInWithEmailAndPasswordScreen(navController = navController)
            }
            composable(route = Screen.SignUpWithEmailAndPasswordScreen.route) {
                SignUpWithEmailAndPasswordScreen(navController = navController)
            }
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Screen.ExploreScreen.route) {
                ExploreScreen(navController = navController)
            }
            composable(route = Screen.CartScreen.route) {
                CartScreen(navController = navController)
            }
            composable(route = Screen.FavouritesScreen.route) {
                FavouriteScreen(navController = navController)
            }
            composable(route = Screen.ProfileScreen.route) {
                ProfileScreen(navController = navController)
            }
        }

}