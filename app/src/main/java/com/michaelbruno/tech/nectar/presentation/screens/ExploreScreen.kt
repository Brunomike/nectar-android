package com.michaelbruno.tech.nectar.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaelbruno.tech.nectar.presentation.composables.Search

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(navController: NavController) {
    val searchTerm = remember { mutableStateOf("") }

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
                .padding(top = 8.dp)
        ) {
            val myList = listOf(1..10).map { it.toString() }
            Text(
                text = "Find Products", color = Color.Black, fontSize = 14.sp,
                fontWeight = FontWeight.W700
            )
            Search(searchTerm)
            Spacer(modifier = Modifier.height(8.dp))
//            LazyVerticalGrid(
//                cells = GridCells.Fixed(2),
//                content = {
//                    items(myList.size) { index ->
//                        Card(
//                            backgroundColor = Color.Red,
//                            modifier = Modifier
//                                .padding(4.dp)
//                                .fillMaxWidth(),
//                            elevation = 8.dp
//                        ) {
//                            Text(text = myList[index])
//                        }
//                    }
//                }
//            )
        }
    }
}

@Preview
@Composable
fun ExploreReview() {

    ExploreScreen(navController = rememberNavController())
}