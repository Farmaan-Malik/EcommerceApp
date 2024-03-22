package com.example.ecommerceapp.presentation.ProductScreen.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun MyButton(isSelected:Boolean,Name: String, ApiCall:()-> Unit) {
    val scale = animateFloatAsState(targetValue = if (isSelected)1f else .85f)
    val containerColor = animateColorAsState(
        targetValue = if (isSelected) Color.Black else Color.White,
        label = ""
    )
    val textColor = animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.Gray,
        label = ""
    )
    Button(onClick = {
        ApiCall()
    },
        colors = ButtonDefaults.buttonColors(containerColor.value),
        modifier = Modifier.shadow(shape = CircleShape, elevation = 20.dp, spotColor = Color.DarkGray).graphicsLayer { scaleX = scale.value
        scaleY = scale.value}
    ) {
        Text(text = Name, color = textColor.value)
    }
}