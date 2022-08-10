package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.Constants
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.Screen
import com.michaelbruno.tech.nectar.presentation.composables.Search

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(navController: NavController) {
    val searchTerm = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, bottom = 50.dp)
        ) {

            Text(
                text = "Find Products", color = Color.Black, fontSize = 14.sp,
                fontWeight = FontWeight.W700
            )
            Search(searchTerm)
            Spacer(modifier = Modifier.height(8.dp))

            if (searchTerm.value == "") {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    content = {
                        items(Constants.categoryList.size) { index ->
                            Category(
                                title = Constants.categoryList[index].title,
                                imageUrl = Constants.categoryList[index].imageUrl,
                                color = Constants.categoryList[index].color,
                                onClick = {

                                }
                            )
                        }
                    }
                )
            } else {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    content = {
                        items(Constants.productList.size) { index ->
                            Product(
                                imageUrl = Constants.productList[index].imageUrl,
                                title = Constants.productList[index].title,
                                price = Constants.productList[index].price,
                                quantity = Constants.productList[index].quantity,
                                onClick = {
                                    navController.navigate(Screen.ProductScreen.route)
                                }
                            )
                        }
                    }
                )

                //TODO :Fetch appropriate products of searched value or category
            }

        }

    }
}

data class CategoryKt(
    val title: String,
    val imageUrl: Int,
    val color: Color
)

@Composable
fun Category(title: String, imageUrl: Int, color: Color, onClick: () -> Unit) {
    Card(
        backgroundColor = color.copy(alpha = 0.25f),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 1.dp, shape = RoundedCornerShape(8.dp), color = color)
            .defaultMinSize(minHeight = 150.dp)
            .clickable {
                onClick()
            },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = title
            )
            Text(
                text = title,
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.fillMaxWidth(.8f)
            )
        }
    }
}