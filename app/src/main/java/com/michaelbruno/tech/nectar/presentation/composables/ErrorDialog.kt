package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.Screen

@Composable
fun ErrorDialog(navController: NavController,openDialog:MutableState<Boolean>) {
    //val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        backgroundColor = Color.White,
        title = {
            Text(
                text = "Alert Dialog Title",
                style = MaterialTheme.typography.h1,
                color = Color.Black
            )
        },
        text = {
            Text(
                "Describes the purpose of Alert Dialog",
                fontSize = 14.sp,
                color = Color.LightGray
            )
        },
        buttons = {
            Column(
                modifier = Modifier.padding(all = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF53B175)),
                    onClick = { openDialog.value = false }
                ) {
                    Text("Please Try Again", color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Back to home",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable(enabled = true) {
                            navController.navigate(Screen.HomeScreen.route)
                        }
                )
            }
        }
    )

//    Dialog(onDismissRequest = { /*TODO*/ }) {
//
//    }
}