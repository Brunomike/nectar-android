package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michaelbruno.tech.nectar.R

@Composable
fun Search(searchTerm: MutableState<String>) {
    TextField(
        value = searchTerm.value,
        onValueChange = {
            searchTerm.value = it
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search Product",
                tint = Color.Black
            )
        },
        placeholder = {
            if (searchTerm.value == "") Text(text = "Search Store", color = Color.Gray)
        },
        textStyle = TextStyle(
            color = Color.DarkGray,
        ),
        colors = TextFieldDefaults.textFieldColors(
            placeholderColor = Color.Gray,
//            focusedIndicatorColor = Color(0xFF53B175),
//            unfocusedIndicatorColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color(0xFF53B175)
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFF2F3F2))
    )


}

@Preview
@Composable
fun SearchPrev() {
    val searchTerm = remember { mutableStateOf("") }
    Search(searchTerm)
}