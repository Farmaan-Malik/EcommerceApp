package com.example.ecommerceapp.presentation.ProductScreen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.ecommerceapp.data.remote.responses.products.Rating

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListCard(
    image: String,
    price: Double,
    rating: Rating,
    title: String
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
//            .wrapContentWidth(Alignment.CenterHorizontally)
            .fillMaxWidth()
//            .background(Color.Gray)
//            .fillMaxHeight()
            .clip(RoundedCornerShape(15))
    ) {
        Image(
            modifier = Modifier
                .padding(bottom = 36.dp)
//                    .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Fit,
            painter = rememberAsyncImagePainter(image),
            contentDescription = null
        )

        Text(title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(
            rating.rate.toString(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text("$ $price", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}
