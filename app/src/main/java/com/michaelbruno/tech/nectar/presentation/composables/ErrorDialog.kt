package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen
import com.michaelbruno.tech.nectar.ui.theme.fonts

@Composable
fun ErrorDialog(navController: NavController, openDialog: MutableState<Boolean>) {
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

}

@Composable
fun CustomErrorDialog(showDialog: Boolean, onClose: () -> Unit) {
    if (showDialog) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .fillMaxWidth(.9f)
//                    .fillMaxHeight(.8f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White)
                ) {
                    IconButton(
                        modifier = Modifier
                            .padding(4.dp)
                            .background(Color.White)
                            .align(Alignment.Start)
                            .offset(x = (-8).dp, y = (-8).dp),
                        onClick = { onClose() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cancel_dialog),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .size(10.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.error),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "Ooops! Order Failed",
                        color = Color.Black,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Something went wrong...",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color(0xFF7C7C7C)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(.95f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF53B175),
                            contentColor = Color.White
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(text = "Please Try Again", color = Color.White, fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Back to home",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.clickable {

                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}