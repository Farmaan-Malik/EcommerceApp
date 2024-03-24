package com.example.ecommerceapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun MyBottomBar(navController: NavController) {
    BottomAppBar(modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 80.dp),
        actions = {
            NavigationBarItem(
                selected = navController.currentDestination?.route == "Home",
                label = {
                    Text(
                        text = "Home",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                alwaysShowLabel = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = if (navController.currentDestination?.route == "Home") Icons.Default.Home else Icons.Outlined.Home,
                        contentDescription = "",
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    indicatorColor = Color.Black
                )
            )
            NavigationBarItem(
                selected = navController.currentDestination?.route == "WishList",
                label = {
                    Text(
                        text = "WishList",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                alwaysShowLabel = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = if (navController.currentDestination?.route == "WishList") Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "",
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    indicatorColor = Color.Black
                )
            )
            NavigationBarItem(
                selected = navController.currentDestination?.route == "Cart",
                label = {
                    Text(
                        text = "Cart",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                alwaysShowLabel = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = if (navController.currentDestination?.route == "Cart") Icons.Default.ShoppingCart else Icons.Outlined.ShoppingCart,
                        contentDescription = "",
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    indicatorColor = Color.Black
                )
            )
        })
}