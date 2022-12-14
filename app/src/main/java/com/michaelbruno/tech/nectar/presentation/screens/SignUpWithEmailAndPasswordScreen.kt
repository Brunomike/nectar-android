package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.*
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen
import com.michaelbruno.tech.nectar.presentation.composables.AppLogo

@Composable
fun SignUpWithEmailAndPasswordScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(.3f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main),
                contentDescription = null,
                modifier= Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .scale(1.5f)
                    .rotate(-20f)
                    .zIndex(0f)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .zIndex(1f)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xEEFCFCFC))
                    .height(64.dp)

            ) {
                AppLogo(Color(0xFFF3603F), Color(0xFF53B175))
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
       Box(
           modifier=Modifier
               .align(Alignment.BottomCenter)
               .fillMaxHeight(.7f)
       ){
           Column(
               modifier = Modifier
                   .padding(horizontal = 16.dp)
                   .verticalScroll(state = scrollState, enabled = true)
                   .background(Color.White)
                   .fillMaxHeight()
           ) {

               Spacer(modifier = Modifier.height(16.dp))
               Text(text = "Sign Up", fontSize = 20.sp, color = Color.Black)
               //Spacer(modifier = Modifier.height(8.dp))
               //Text(text = "Enter your credentials to continue", fontSize = 14.sp, color = Color.Gray)
               Spacer(modifier = Modifier.height(16.dp))

               Text(text = "Username", fontSize = 14.sp, color = Color.Gray)
               TextField(
                   value = username.value,
                   onValueChange = {
                       username.value = it
                   },
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                   colors = TextFieldDefaults.textFieldColors(
                       backgroundColor = Color.White,
                       textColor = Color.Black,
                       placeholderColor = Color.LightGray,
                       focusedIndicatorColor = Color(0xFF53B175),
                       unfocusedIndicatorColor = Color.Gray,
                       cursorColor = Color(0xFF53B175)
                   ),
                   modifier = Modifier.padding(0.dp)
               )
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
               Row(
                   modifier = Modifier
                       .fillMaxWidth(.8f)
                       .height(32.dp)

               ) {
                   Text(text = "By continuing you agree to our ", fontSize = 14.sp, color = Color.Gray)
                   Text(
                       text = "Terms of Service ",
                       fontSize = 14.sp, color = Color(0xFF53B175),
                       modifier = Modifier
                   )
                   Text(text = "and ", fontSize = 14.sp, color = Color.Gray)
                   Text(
                       text = "Privacy Policy.",
                       fontSize = 14.sp, color = Color(0xFF53B175),
                       modifier = Modifier
                   )
               }
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
                       text = "Sign Up",
                       modifier = Modifier
                           .align(Alignment.CenterVertically)
                           .padding(vertical = 8.dp),
                       fontSize = 16.sp
                   )
               }

               Spacer(modifier = Modifier.height(16.dp))

               Row(
                   modifier = Modifier
                       .align(Alignment.CenterHorizontally)
                       .padding(bottom = 16.dp)
               ) {
                   Text(text = "Already have an account?", fontSize = 14.sp, color = Color.Black)
                   Spacer(modifier = Modifier.width(8.dp))
                   Text(
                       text = "Signin",
                       fontSize = 14.sp, color = Color(0xFF53B175),
                       modifier = Modifier
                           .clickable(enabled = true) {
                               navController.navigate(Screen.SignInWithEmailAndPasswordScreen.route)
                           }
                   )
               }
           }
       }
    }

}

@Preview
@Composable
fun SignUpPrev() {
    val navController = rememberNavController()
    SignUpWithEmailAndPasswordScreen(navController = navController)
}