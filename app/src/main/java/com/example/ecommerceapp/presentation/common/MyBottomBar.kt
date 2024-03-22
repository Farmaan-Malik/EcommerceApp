package com.example.ecommerceapp.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun MyBottomBar() {
    BottomAppBar(
        actions = {
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        modifier = Modifier.zIndex(2f)
                    )
                })
            NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "",
                    modifier = Modifier.zIndex(2f)
                )
            })
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        modifier = Modifier.zIndex(2f)
                    )
                })
        },
//        floatingActionButton = {
//        FloatingActionButton(shape = RectangleShape,
//            elevation = FloatingActionButtonDefaults.elevation(1.dp),
//            modifier = Modifier.shadow(20.dp).clip(RoundedCornerShape(33)),
//            containerColor = Color(
//                0xFFF55424
//            ),
//            onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Outlined.ShoppingCart,
//                contentDescription = "",
//                tint = Color.White
//            )
//        }
//    },
        modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(horizontal = 80.dp)
    )
}