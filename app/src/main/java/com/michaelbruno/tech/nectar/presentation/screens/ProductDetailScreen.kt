package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michaelbruno.tech.nectar.R

@Composable
fun ProductDetailScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f)
            ) {

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f)
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
                        Text(text = "Natural Red Apple", color = Color.LightGray, fontSize = 16.sp)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favourite),
                            contentDescription = "Mark as favourite",
                            tint = Color.LightGray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                                contentDescription = "Increase product quantity"
                            )

                        }
                        Text(text = "1", fontSize = 14.sp, color = Color.Black)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_horizontal_rule_24),
                                contentDescription = "Increase product quantity"
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


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                    ,
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Add To Cart", color = Color.White)
                }
            }
        }
    }

    //TODO: Replace with real data reflecting selected item by user
}