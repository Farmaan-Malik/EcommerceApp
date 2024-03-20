package com.example.ecommerceapp.presentation.ProductScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun MyAppBar() {
    TopAppBar(title = {
        Text(
            text = "Spree",
            fontStyle = FontStyle.Italic, modifier = Modifier.padding(start = 10.dp)
        )
    },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = Color.White,
        actions = {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null,
                modifier = Modifier
                    .clickable { /*TODO*/ }
                    .padding(end = 15.dp))
            Icon(imageVector = Icons.Outlined.Person, contentDescription = null, modifier = Modifier
                .clickable { /*TODO*/ }
                .padding(end = 15.dp, start = 5.dp))
        })

}