package com.michaelbruno.tech.nectar.presentation.screens

import android.widget.GridView
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
import com.michaelbruno.tech.nectar.R
import com.michaelbruno.tech.nectar.presentation.composables.AppLogo
import com.michaelbruno.tech.nectar.presentation.composables.Search
import kotlin.math.min

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val searchTerm = remember { mutableStateOf("") }
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
            .padding(horizontal = 16.dp)
            .verticalScroll(
                state = rememberScrollState(),
                enabled = true
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ) {
            AppLogo(Color(0xFFF3603F), Color(0xFF53B175), .5f)
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null,
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Nairobi, Kenya", color = Color.Black)
            }

            Search(searchTerm)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                //contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(productList.size) { index ->
                    Product(
                        imageUrl = productList[index].imageUrl,
                        title = productList[index].title,
                        price = productList[index].price,
                        quantity = productList[index].quantity
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))
            val list = (1..10).map { it.toString() }

            LazyVerticalGrid(
                cells = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 16.dp
                ),
                content = {
                    items(list.size) { index ->
                        Card(
                            backgroundColor = Color.Red,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth(),
                            elevation = 8.dp
                        ) {
                            Text(
                                text = list[index],
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            )




            Spacer(modifier = Modifier.width(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,

                modifier = Modifier.fillMaxWidth()
            ) {
                Product(
                    imageUrl = productList[0].imageUrl,
                    title = productList[0].title,
                    price = productList[0].price,
                    quantity = productList[0].quantity
                )
                Product(
                    imageUrl = productList[0].imageUrl,
                    title = productList[0].title,
                    price = productList[0].price,
                    quantity = productList[0].quantity
                )
            }
        }


    }
}

@Composable
fun Product(imageUrl: Int, title: String, price: Float, quantity: String) {
    Box() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 1.dp, shape = RoundedCornerShape(8.dp), color = Color.LightGray)
                .padding(8.dp)
                .fillMaxSize()
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
                    onClick = { /*TODO*/ }
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


    Product(
        imageUrl = productList[0].imageUrl,
        title = productList[0].title,
        price = productList[0].price,
        quantity = productList[0].quantity
    )

//    Box(modifier = Modifier.fillMaxSize()) {
//        LazyVerticalGrid(
//            cells = GridCells.Fixed(2),
//            contentPadding = PaddingValues(16.dp),
//            content = {
//                items(productList.size) { index ->
//                    Product(
//                        imageUrl = productList[index].imageUrl,
//                        title = productList[index].title,
//                        price = productList[index].price,
//                        quantity = productList[index].quantity
//                    )
//                }
//            }
//        )
//    }


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