package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.Screen
import com.michaelbruno.tech.nectar.presentation.composables.AppLogo
import com.michaelbruno.tech.nectar.R


@Composable
fun OnBoardingScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter=painterResource(id = R.drawable.onboarding),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .scale(1.2f)
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier=Modifier
                .padding(bottom = 64.dp)
        ) {
            AppLogo()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Welcome\n to our store",
                fontSize = 36.sp,
                fontWeight = FontWeight.W500,
                maxLines = 2,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Get your groceries in as fast as one hour",
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                color = Color.LightGray,

                )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF53B175),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .clip(RoundedCornerShape(16.dp)),
                onClick = {
                    navController.navigate(Screen.SignInWithEmailAndPasswordScreen.route)
                }
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier
                        .align(CenterVertically)
                        .padding(vertical = 8.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    val navController= rememberNavController()
    OnBoardingScreen(navController = navController)
}
