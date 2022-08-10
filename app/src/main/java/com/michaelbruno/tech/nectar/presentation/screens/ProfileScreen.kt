package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen

@Composable
fun ProfileScreen(navController: NavController) {
    val profileItems: List<ProfileScreenItem> = listOf(
        ProfileScreenItem(
            icon = R.drawable.ic_orders,
            title = "Orders",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_details,
            title = "My Details",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_location,
            title = "Delivery Address",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_payment,
            title = "Payment Methods",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_promo_code,
            title = "Promo Code",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_notifications,
            title = "Notifications",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_help,
            title = "Help",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
        ProfileScreenItem(
            icon = R.drawable.ic_about,
            title = "About",
            route = Screen.SplashScreen.route,
            navController = navController
        ),
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(enabled = true, state = rememberScrollState())
            .padding(bottom = 90.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterStart)
                    .height(100.dp)
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bruno_twitter),
                    contentDescription = "User profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.padding(bottom = 4.dp)) {
                    Text(text = "Michael Bruno", color = Color.Black, fontWeight = FontWeight.Bold)
                    Text(text = "michael@gmail.com", color = Color.LightGray)
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE2E2E2))
        )
        Column(modifier = Modifier.background(Color.White)) {
            profileItems.forEachIndexed { index, profileScreenItem ->
                ProfileItem(
                    icon = profileScreenItem.icon,
                    title = profileScreenItem.title,
                    route = profileScreenItem.route,
                    navController = profileScreenItem.navController
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(.9f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF2F3F2), RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                tint = Color(0xFF53B175),
                modifier = Modifier
            )
            Text(text = "Log Out", color = Color(0xFF53B175))
        }

    }
}


@Composable
fun ProfileItem(
    icon: Int,
    title: String,
    route: String,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "title",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(20.dp)

                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    color = Color(0xFF181725),
                    fontSize = 16.sp
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                contentDescription = "$title screen",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        navController.navigate(route)
                    }
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE2E2E2))
        )
    }

}

data class ProfileScreenItem(
    val icon: Int,
    val title: String,
    val route: String,
    val navController: NavController
)

@Preview
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()

    ProfileScreen(navController)
}