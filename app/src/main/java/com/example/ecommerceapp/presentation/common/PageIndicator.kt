package com.example.ecommerceapp.presentation.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int ) {
    Row(
        modifier = Modifier
            .padding(horizontal = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
                    repeat(pageCount) {
                        IndicatorLines(
                            isSelected = it == currentPage
                        )
            }

    }
}

@Composable
fun IndicatorLines(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 30.dp else 8.dp, label = "")
    val height = animateDpAsState(targetValue = if (isSelected) 6.dp else 4.dp, label = "")
    Box(modifier= Modifier
        .width(width.value)
        .height(height.value)
        .padding(horizontal = 2.dp)
        .clip(CircleShape)
        .background(Color.Black))
}
