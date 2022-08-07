package com.michaelbruno.tech.nectar

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.michaelbruno.tech.nectar.presentation.composables.BottomNavigation
import com.michaelbruno.tech.nectar.presentation.screens.*

@Composable
fun Navigation(navController: NavHostController, scaffoldState: ScaffoldState) {
    val screensWithBottomNavigation = listOf(
        Screen.HomeScreen,
        Screen.ExploreScreen,
        Screen.CartScreen,
        Screen.FavouritesScreen,
        Screen.ProfileScreen
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            Log.d("CURRENT_SCREEN", navController.currentDestination?.route.toString())
            Log.d("CURRENT", navController.currentDestination?.displayName.toString())
            navController.currentDestination?.toString()?.let { Log.d("CURRENT", it) }
            if (navController.currentDestination?.route in screensWithBottomNavigation.map { item -> item.route }
            ) {
                BottomNavigation(navController = navController)
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
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
}