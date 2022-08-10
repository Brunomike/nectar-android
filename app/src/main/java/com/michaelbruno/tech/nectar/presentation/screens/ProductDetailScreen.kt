package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.presentation.composables.Dropdown

@Composable
fun ProductDetailScreen(navController: NavController) {
    val productQuantity = remember { mutableStateOf(1) }
    val totalProductQuantity = remember { mutableStateOf(10) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize().fillMaxHeight().fillMaxWidth()
                .verticalScroll(state = rememberScrollState(), enabled = true)
                .background(Color.White)
                .padding(bottom = 90.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .background(Color(0xFFF2F3F2))
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                            contentDescription = "Back to products",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(18.dp)
                                .clickable {
                                    navController.currentBackStackEntry
                                }
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.banana),
                        contentDescription = "Product Title",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(100.dp)
                    )

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .padding(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Natural Red Apple",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700
                        )
                        Text(
                            text = "1kg, Price",
                            color = Color(0xFF7C7C7C),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favourite),
                            contentDescription = "Mark as favourite",
                            tint = Color(0xFF7C7C7C),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            enabled = productQuantity.value > 1,
                            onClick = {
                                if (productQuantity.value > 1) {
                                    productQuantity.value--
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_horizontal_rule_24),
                                contentDescription = "Increase product quantity",
                                modifier = Modifier.size(15.dp),
                                tint = if (productQuantity.value > 1) Color(0xFF53B175) else Color(
                                    0xFF7C7C7C
                                )

                            )

                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(4.dp))
                        ) {
                            Text(
                                text = "${productQuantity.value}",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(8.dp, 4.dp)
                            )
                        }
                        IconButton(
                            enabled = productQuantity.value < totalProductQuantity.value,
                            onClick = {
                                productQuantity.value++
                                //TODO: Implement validation for available product count,allowing customer increase counter to the number of selected product available
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                                contentDescription = "Increase product quantity",
                                modifier = Modifier.size(15.dp),
                                tint = if (productQuantity.value < totalProductQuantity.value) Color(
                                    0xFF53B175
                                ) else Color(
                                    0xFF7C7C7C

                                )
                            )
                        }

                    }
                    Text(
                        text = "$4.99",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE2E2E2))
                )

                Dropdown(text = "Product Detail", initiallyOpened = true) {
                    Text(
                        text = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart as part of a healthy and varied diet.",
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.Thin,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE2E2E2))
                )
                Dropdown(text = "Nutrition", initiallyOpened = false) {
                    Text(
                        text = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart as part of a healthy and varied diet.",
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.Thin,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE2E2E2))
                )
                Dropdown(text = "Review", initiallyOpened = false) {
                    Text(
                        text = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart as part of a healthy and varied diet.",
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.Thin,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))


                Button(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF53B175),
                        contentColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Add To Cart", color = Color.White)
                }
            }
        }
    }

    //TODO: Replace with real data reflecting selected item by user
}