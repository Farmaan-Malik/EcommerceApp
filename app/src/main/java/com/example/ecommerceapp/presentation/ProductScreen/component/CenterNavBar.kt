package com.example.ecommerceapp.presentation.ProductScreen.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.presentation.ProductScreen.ProductScreenVIewModel


@Composable
fun CenterNavBar(vIewModel: ProductScreenVIewModel) {
    Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center, Alignment.Bottom) {

        MyButton( Name = "All", isSelected = vIewModel.selectedCategory.value.lowercase() == "all" ) {
           vIewModel.getList()
        }
        MyButton( Name = "Jewellery", isSelected = vIewModel.selectedCategory.value.lowercase() == "jewelery" ) {
           vIewModel.getCategoryList("jewelery")
        }
        MyButton( Name = "Men's", isSelected = vIewModel.selectedCategory.value.lowercase() == "men's clothing") {
            vIewModel.getCategoryList("men's clothing")
        }
        MyButton( Name = "Women's", isSelected = vIewModel.selectedCategory.value.lowercase() == "women's clothing") {
            vIewModel.getCategoryList("women's clothing")
        }
        MyButton( Name = "Electronics", isSelected = vIewModel.selectedCategory.value.lowercase() == "electronics") {
            vIewModel.getCategoryList("electronics")
        }

//        Button(
//            onClick = {
//                vIewModel.getCategoryList("jewelery")
//                ButtonState.value = "Jewelery"
//            },
//            modifier = Modifier
//                .wrapContentSize()
//                .height(50.dp)
//                .padding(start = 10.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = containerColor.value
//            )
//        ) {
//            Text(text = "Jewellery", color = textColor.value)
//        }
//        Button(
//            onClick = {
//                vIewModel.getCategoryList("men's clothing")
//                ButtonState.value = "Men's clothing"
//            },
//            modifier = Modifier
//                .wrapContentSize()
//                .height(50.dp)
//                .padding(start = 10.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = containerColor.value
//            )
//        ) {
//            Text(text = "Men's", color = textColor.value)
//        }
//        Button(
//            onClick = {
//                vIewModel.getCategoryList("women's clothing")
//                ButtonState.value = "Women's clothing"
//            },
//            modifier = Modifier
//                .wrapContentSize()
//                .height(50.dp)
//                .padding(start = 10.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = containerColor.value
//            )
//        ) {
//            Text(text = "Women's", color = textColor.value)
//        }
//        Button(
//            onClick = {
//                vIewModel.getCategoryList("electronics")
//                ButtonState.value = "Electronics"
//            },
//            modifier = Modifier
//                .wrapContentSize()
//                .height(50.dp)
//                .padding(start = 10.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = containerColor.value
//            )
//        ) {
//            Text(text = "Electronics", color = textColor.value)
//        }
    }
}



