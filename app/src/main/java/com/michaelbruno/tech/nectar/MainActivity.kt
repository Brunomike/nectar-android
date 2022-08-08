package com.michaelbruno.tech.nectar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.presentation.composables.BottomNavigation
import com.michaelbruno.tech.nectar.presentation.screens.ProfileScreen
import com.michaelbruno.tech.nectar.ui.theme.NectarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NectarTheme {
                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()

                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {
                        Log.d("CURRENT_SCREEN", navController.currentDestination?.route.toString())
                        Log.d("CURRENT", navController.currentDestination?.displayName.toString())
                        navController.currentDestination?.toString()?.let { Log.d("CURRENT", it) }
//                        if (navController.currentDestination?.route in Constants.screensWithBottomNavigation.map { item -> item.route }
//                        ) {
//                            BottomNavigation(navController = navController)
//                        }
                        BottomNavigation(navController = navController)
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Log.d("CURRENT", navController.currentDestination?.route.toString())
                    Navigation(navController = navController)
                }

            }

        }
    }
}

