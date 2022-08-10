package com.michaelbruno.tech.nectar

import androidx.compose.ui.graphics.Color
import com.michaelbruno.tech.nectar.presentation.screens.CategoryKt
import com.michaelbruno.tech.nectar.presentation.screens.ProductKt

object Constants {
    val screensWithBottomNavigation = listOf(
        Screen.HomeScreen,
        Screen.ExploreScreen,
        Screen.CartScreen,
        Screen.FavouritesScreen,
        Screen.ProfileScreen
    )

    val productList: List<ProductKt> = listOf(
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 30
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 20
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 15
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 4
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 16
        ),
        ProductKt(
            imageUrl = R.drawable.banana,
            title = "Organic Bananas",
            price = 4.99f,
            quantity = "1kg",
            totalItems = 100
        ),
    )

    val categoryList = listOf(
        CategoryKt(
            title = "Fresh Fruits & Vegetables",
            imageUrl = R.drawable.fruits_and_vegetables,
            Color(0xFF53B175)
        ),
        CategoryKt(
            title = "Cooking Oil & Ghee",
            imageUrl = R.drawable.oil_and_ghee,
            Color(0xFFF8A44C)
        ),
        CategoryKt(title = "Meat & Fish", imageUrl = R.drawable.meat_and_fish, Color(0xFFF7A593)),
        CategoryKt(
            title = "Bakery & Snacks",
            imageUrl = R.drawable.bakery_and_snacks,
            Color(0xFFD3B0E0)
        ),
        CategoryKt(title = "Dairy & Eggs", imageUrl = R.drawable.dairy_and_eggs, Color(0xFFFDE598)),
        CategoryKt(title = "Beverages", imageUrl = R.drawable.beverages, Color(0xFFB7DFF5)),
    )

    val myCart: List<ProductKt> = listOf()
}