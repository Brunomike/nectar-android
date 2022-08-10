package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michaelbruno.tech.nectar.R

@Composable
fun Search(searchTerm: MutableState<String>) {
    val isSearching = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = searchTerm.value,
            onValueChange = {
                searchTerm.value = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "Search Product",
                    tint = Color(0XFF181B19)
                )
            },
            trailingIcon = {
                if (isSearching.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = "Cancel Search",
                        tint = Color(0XFF181B19),
                        modifier = Modifier.clickable {
                            searchTerm.value = ""
                        }
                    )
                }
            },
            placeholder = {
                if (searchTerm.value == "") Text(
                    text = "Search Store",
                    color = Color(0xFF7C7C7C),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Thin
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF53B175),
                textColor = Color.LightGray
            ),
            textStyle = TextStyle(fontWeight = FontWeight.Thin),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth(if (isSearching.value) .8f else 1f)
                .padding(8.dp)
                .height(50.dp)
                .background(Color(0xFFF2F3F2))
        )

        if (!isSearching.value) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "Filter search results",
                tint = Color(0xFF181725)
            )
        }
    }


}

@Preview
@Composable
fun SearchPrev() {
    val searchTerm = remember { mutableStateOf("") }
    Search(searchTerm)
}