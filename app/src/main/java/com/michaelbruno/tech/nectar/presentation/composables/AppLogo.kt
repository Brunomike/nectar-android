package com.michaelbruno.tech.nectar.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michaelbruno.tech.nectar.R

@Composable
fun AppLogo(baseColor: Color? = null) {
    Box(
        modifier = Modifier
            .width(55.dp)
            .height(64.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_carrot_leaves),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .height(24.dp)
                .offset(y = 8.dp, x = -(7).dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_carrot_fruit), contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .height(40.dp),
            colorFilter = if (baseColor != null) ColorFilter.tint(baseColor) else ColorFilter.tint(
                Color.White
            )
        )

    }
}
//x55-y64

@Preview
@Composable
fun LogoPreview(modifier: Modifier = Modifier.background(Color.Black)) {
    AppLogo()
}