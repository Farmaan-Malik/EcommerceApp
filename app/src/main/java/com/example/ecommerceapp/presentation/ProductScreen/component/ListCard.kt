package com.example.ecommerceapp.presentation.ProductScreen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.ecommerceapp.data.remote.responses.products.Rating

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListCard(
    image: String, price: Double, rating: Rating, title: String, navigate:()-> Unit
) {
    Card(onClick = { navigate() },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 20.dp)
            .fillMaxWidth()
            .shadow(elevation = 20.dp, spotColor = Color.DarkGray, shape = RoundedCornerShape(15)),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 25.dp, top = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null, Modifier.clickable { /*TODO*/ }
            )
        }
        Image(
            modifier = Modifier
                .padding(bottom = 36.dp)
                .padding(horizontal = 12.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Fit,
            painter = rememberAsyncImagePainter(image),
            contentDescription = null
        )
        Text(
            title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp), horizontalArrangement = Arrangement.Center
        ) {
            for (x in 1..rating.rate.toInt()) {
                Icon(
                    imageVector = Icons.Filled.Star, contentDescription = null, tint = Color(
                        0xFFFFC107
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "(${rating.count})", fontSize = 14.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "$", fontWeight = FontWeight.Bold)
            Text(" $price", textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
        }
    }
}
