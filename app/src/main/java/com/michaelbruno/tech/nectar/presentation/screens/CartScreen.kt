package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.michaelbruno.tech.nectar.Constants
import com.michaelbruno.tech.nectar.R

@Composable
fun CartScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 70.dp)
                .background(Color.White)
        ) {

            item {
                Text(
                    text = "My Cart", color = Color.Black, fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE2E2E2))
                )
            }

            items(Constants.productList.size) { index ->
                CartItem(product = Constants.productList[index])
            }

            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                )
            }
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF53B175),
                            contentColor = Color.White
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(text = "Go to Checkout", color = Color.White)
                    }
                }
            }
        }

    }
}


@Composable
fun CartItem(product: ProductKt) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = product.imageUrl),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start,

                            ) {
                            Text(
                                text = product.title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W700,
                                color = Color.Black
                            )
                            Text(
                                text = product.quantity,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Thin,
                                color = Color(0xFF7C7C7C)
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cancel_dialog),
                            contentDescription = "Remove product from cart",
                            modifier = Modifier.size(12.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        val pQuantity = remember { mutableStateOf(1) }
                        val pTotalQuantity = remember { mutableStateOf(product.totalItems) }
                        QuantityCounter(
                            productQuantity = pQuantity,
                            totalProductQuantity = pTotalQuantity
                        )
                        val total = pQuantity.value * product.price
                        Text(text = "$${total.toDouble()}", fontWeight = FontWeight.W700, color = Color.Black)
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE2E2E2))
        )
    }
}

@Composable
fun QuantityCounter(
    productQuantity: MutableState<Int>,
    totalProductQuantity: MutableState<Int?>,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
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
            enabled = productQuantity.value < totalProductQuantity.value!!,
            onClick = {
                productQuantity.value++
                //TODO: Implement validation for available product count,allowing customer increase counter to the number of selected product available
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = "Increase product quantity",
                modifier = Modifier.size(15.dp),
                tint = if (productQuantity.value < totalProductQuantity.value!!) Color(
                    0xFF53B175
                ) else Color(
                    0xFF7C7C7C

                )
            )
        }
    }
}

data class CartProductItem(
    val product: ProductKt,
    var productCount: Int
)