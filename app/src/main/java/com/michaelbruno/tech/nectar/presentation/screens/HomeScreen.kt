package com.michaelbruno.tech.nectar.presentation.screens

import android.widget.GridView
import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.presentation.composables.AppLogo
import com.michaelbruno.tech.nectar.presentation.composables.ErrorDialog
import com.michaelbruno.tech.nectar.presentation.composables.Search
import com.michaelbruno.tech.nectar.ui.theme.fonts
import kotlin.math.min

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val searchTerm = remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }
    val productList: List<ProductKt> = listOf(
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
    )

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
                .padding(top = 8.dp,bottom = 70.dp)
        ) {
            //AppLogo(Color(0xFFF3603F), Color(0xFF53B175), .5f)
            Image(
                painter = painterResource(id = R.drawable.colored_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location_dark),
                    contentDescription = null,
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Nairobi, Kenya",
                    color = Color.Black,
                    style = MaterialTheme.typography.body2,
                    fontSize = 12.sp
                )
            }

            Search(searchTerm)

            Spacer(modifier = Modifier.width(8.dp))

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
//                contentPadding = PaddingValues(
//                    start = 12.dp,
//                    top = 16.dp,
//                    end = 12.dp,
//                    bottom = 16.dp
//                ),
                content = {
                    items(productList.size) { index ->
                        Product(
                            imageUrl = productList[index].imageUrl,
                            title = productList[index].title,
                            price = productList[index].price,
                            quantity = productList[index].quantity
                        )
                    }
                }
            )


            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { openDialog.value = !openDialog.value }
            ) {
                Text(text = "Show Dialog", color = Color.White)
            }
            ErrorDialog(navController, openDialog)

        }


    }
}

@Composable
fun Product(imageUrl: Int, title: String, price: Float, quantity: String) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .border(width = 1.dp, shape = RoundedCornerShape(8.dp), color = Color.LightGray)
            .defaultMinSize(minHeight = 150.dp),
        //elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.banana),
                contentDescription = title,
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontWeight = FontWeight.W700, color = Color.Black, fontSize = 12.sp)
            Text(text = quantity, color = Color(0xFF7C7C7C), fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "$$price",
                    fontWeight = FontWeight.W700,
                    color = Color.Black,
                    fontSize = 12.sp
                )
                IconButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(20.dp)
                        .background(Color(0xFF53B175)),
                    onClick = {
                        /*TODO*/
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "Add product to cart",
                        tint = Color.White,
                        modifier = Modifier
                            .size(15.dp)
                    )
                }
            }
        }
    }

    //TODO: Change the product to accept url
}


@Composable
fun Offers(
    title: String,
    offerText: String,
    largeImage: Int,
    topRightImage: Int,
    bottomRightImage: Int
) {

}

data class ProductKt(
    val imageUrl: Int,
    val title: String,
    val price: Float,
    val quantity: String
)

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ProductPreview() {
    val productList: List<ProductKt> = listOf(
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg"
        ),
    )
    HomeScreen(navController = rememberNavController())
}

//@Preview
//@Composable
//fun OffersPreview() {
//
//}


//        LazyVerticalGrid(
//            cells = GridCells.Fixed(2),
//            content = {
//                items(productList.size) { index ->
//                        Product(
//                            imageUrl = productList[index].imageUrl,
//                            title = productList[index].title,
//                            price = productList[index].price,
//                            quantity = productList[index].quantity
//                        )
//                    Card(
//                        backgroundColor = Color.Red,
//                        modifier = Modifier.padding(4.dp)
//                            .fillMaxWidth(),
//                        elevation = 8.dp
//                    ) {
//
//                    }
//                }
//            }
//        )