package com.example.ecommerceapp.presentation.ProductScreen.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CenterNavBar() {
    Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
        var ButtonState = remember { mutableStateOf(true) }
        val containerColor = animateColorAsState(targetValue = if (ButtonState.value) Color.Black else Color.White,
            label = ""
        )
        val textColor = animateColorAsState(targetValue = if (ButtonState.value) Color.White else Color.Gray,
            label = ""
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .wrapContentSize()
                .height(50.dp)
                .padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor.value)
        ) {
            Text(text = "Jewellery", color = textColor.value)
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .wrapContentSize()
                .height(50.dp)
                .padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor.value
            )
        ) {
            Text(text = "Men's", color = textColor.value)
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .wrapContentSize()
                .height(50.dp)
                .padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor.value
            )
        ) {
            Text(text = "Women's", color = textColor.value)
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .wrapContentSize()
                .height(50.dp)
                .padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor.value)
        ) {
            Text(text = "Electronics", color = textColor.value)
        }
    }
}



