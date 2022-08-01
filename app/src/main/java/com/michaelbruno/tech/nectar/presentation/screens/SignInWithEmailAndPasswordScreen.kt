package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen
import com.michaelbruno.tech.nectar.presentation.composables.AppLogo


@Composable
fun SignInWithEmailAndPasswordScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 32.dp)
        ) {
            AppLogo(Color.Red, Color.Green)
            Spacer(modifier = Modifier.height(16.dp))
        }
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Log In", fontSize = 20.sp, color = Color.Black)
            //Spacer(modifier = Modifier.height(8.dp))
            //Text(text = "Enter your email and password", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Email", fontSize = 14.sp, color = Color.Gray)
            TextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    placeholderColor = Color.LightGray,
                    focusedIndicatorColor = Color(0xFF53B175),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color(0xFF53B175)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Password", fontSize = 14.sp, color = Color.Gray)

            TextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    placeholderColor = Color.LightGray,
                    focusedIndicatorColor = Color(0xFF53B175),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color(0xFF53B175)
                ),
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value =
                            passwordVisibility.value != true
                    }) {
                        Icon(
                            painter = painterResource(id = if (passwordVisibility.value) R.drawable.visible else R.drawable.invisible),
                            contentDescription = "Password Visibility",
                            tint = Color.DarkGray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgot Password?",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .clickable(enabled = true) {
                        navController.navigate(Screen.OnBoardingScreen.route)
                    }
                    .align(Alignment.End)
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

                }
            ) {
                Text(
                    text = "Log In",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(vertical = 8.dp),
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Don't have an account?", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Signup", fontSize = 14.sp, color = Color(0xFF53B175))
            }
        }


    }
}