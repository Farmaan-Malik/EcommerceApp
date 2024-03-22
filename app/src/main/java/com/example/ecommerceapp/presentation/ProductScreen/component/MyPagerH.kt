package com.example.ecommerceapp.presentation.ProductScreen.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.ecommerceapp.R
import com.example.ecommerceapp.presentation.common.PageIndicator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyPagerH() {
    val images = listOf(
        R.drawable.blackfriday,
        R.drawable.sale,
        R.drawable.shoe
    )
    val state = rememberPagerState {
        images.size
    }
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (state.currentPage + 1) % state.pageCount
            state.scrollToPage(nextPage)
        }
    }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier, Alignment.BottomEnd) {
        HorizontalPager(state = state) { currentPage ->
            Card(
                modifier = Modifier

                    .wrapContentSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(15))
            ) {
                Image(
                    painter = painterResource(id = images[currentPage]),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        IconButton(
            onClick = {
                val nextPage = state.currentPage + 1
                if (nextPage < images.size) {
                    scope.launch {
                        state.scrollToPage(nextPage)
                    }
                }
            }, modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterStart)
                .clip(CircleShape),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0x9C777575))

        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = Color.Black
            )
        }
        IconButton(
            onClick = {
                val previousPage = state.currentPage - 1
                if (previousPage < images.size) {
                    scope.launch {
                        state.scrollToPage(previousPage)
                    }
                }
            }, modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterEnd)
                .clip(CircleShape),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0x9C777575))
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = Color.Black
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .border(2.dp,Color.Green)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            PageIndicator(pageCount = images.size, currentPage = state.currentPage)
        }

    }
}
