package com.michaelbruno.tech.nectar.presentation.screens

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.michaelbruno.tech.nectar.Constants
import com.michaelbruno.tech.nectar.ui.theme.fonts

@Composable
fun FavouriteScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, bottom = 50.dp)
                .background(Color.White)
        ) {
            run {

                item {
                    Text(
                        text = "Favourites", color = Color.Black, fontSize = 14.sp,
                        fontWeight = FontWeight.W700,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
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
                    FavouriteItem(product = Constants.productList[index])
                }

                item { Spacer(modifier = Modifier.height(16.dp)) }

                item {
                    Button(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(.9f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF53B175),
                            contentColor = Color.White
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(text = "Add all to Cart", color = Color.White)
                    }
                }

            }
        }

    }
}


@Composable
fun FavouriteItem(product: ProductKt) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = product.title,
                modifier = Modifier.size(35.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = product.title,
                    fontSize = 15.sp,
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$${product.price}", fontSize = 16.sp, color = Color.Black)

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(20.dp)
                )
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