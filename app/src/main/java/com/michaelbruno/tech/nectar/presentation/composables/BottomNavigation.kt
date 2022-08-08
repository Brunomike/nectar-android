package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen

@Composable
fun BottomNavigation(navController: NavController) {

    val navigationItems = listOf(
        BottomNavigationItem(
            icon = R.drawable.ic_store,
            title = "Shop",
            route = Screen.HomeScreen.route,
            navController = navController
        ),
        BottomNavigationItem(
            icon = R.drawable.ic_explore,
            title = "Explore",
            route = Screen.ExploreScreen.route,
            navController = navController
        ),
        BottomNavigationItem(
            icon = R.drawable.ic_cart,
            title = "Cart",
            route = Screen.CartScreen.route,
            navController = navController
        ),
        BottomNavigationItem(
            icon = R.drawable.ic_favourite,
            title = "Favourite",
            route = Screen.FavouritesScreen.route,
            navController = navController
        ),
        BottomNavigationItem(
            icon = R.drawable.ic_user,
            title = "Account",
            route = Screen.ProfileScreen.route,
            navController = navController
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .shadow(elevation=4.dp,shape= RoundedCornerShape(8.dp), clip = false)
            .height(60.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
                //.shadow(2.dp, RoundedCornerShape(8.dp))
        ) {
            navigationItems.map { item ->
                NavigationItem(
                    icon = item.icon,
                    title = item.title,
                    active = item.active,
                    route = item.route,
                    navController = item.navController
                )
            }
        }
    }
}


@Composable
fun NavigationItem(
    icon: Int,
    title: String,
    active: Boolean,
    route: String,
    navController: NavController,
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(42.dp)
            .clickable {
                navController.navigate(route)
            }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            tint = if (active) Color.Green else Color.Black,
            modifier = Modifier
                .size(25.dp)
        )
        Text(
            text = title,
            color = if (active) Color.Green else Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Thin
        )
    }
}

data class BottomNavigationItem(
    val icon: Int,
    val title: String,
    val active: Boolean = false,
    val route: String,
    val navController: NavController
)