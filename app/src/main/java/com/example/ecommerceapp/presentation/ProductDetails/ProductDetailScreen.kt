package com.example.ecommerceapp.presentation.ProductDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailsViewModel = koinViewModel(), id: Int, navController: NavController
) {
    viewModel.getItemVm(id)

    val isLoading by remember { viewModel.isLoading }
    val isError by remember { viewModel.isError }
    val errorMessage by remember { viewModel.errorMessage }
//    val scaffoldState = rememberBottomSheetScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Spree") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }, modifier = Modifier.shadow(10.dp, spotColor = Color.Black, shape = RoundedCornerShape(50)))
        }
    ) { paddingValues ->

        when {
            isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            isError -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = errorMessage)
                }
            }

            else -> {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding())
                        .padding(16.dp, 16.dp, 16.dp, 0.dp)
                        .verticalScroll(state = rememberScrollState())
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                            .fillMaxWidth()
                            .height(500.dp)
                            .shadow(400.dp, shape = RoundedCornerShape(15))
                            .background(Color(0xFFFFFFFF)), contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = viewModel._productItem.image,
                            contentDescription = null,
                            modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp))
                    }
                    Text(
                        text = viewModel._productItem.title,
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    ) {
                        Text(
                            text = "Category: ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = viewModel._productItem.category.uppercase(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "Rating: ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = "${viewModel._productItem.rating.rate}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            for (star in 1..viewModel._productItem.rating.rate.toInt()) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = Color(
                                        0xFFFFC107
                                    )
                                )
                            }
                            Text(text = "  (${viewModel._productItem.rating.count})")

                        }

                    }
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                    ) {
                        Text(
                            text = "Price: ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = "$${viewModel._productItem.price}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Text(
                        text = "Description:",
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        text = viewModel._productItem.description,
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp,8.dp,0.dp,32.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 30.sp
                    )
                }
            }
        }
    }

}