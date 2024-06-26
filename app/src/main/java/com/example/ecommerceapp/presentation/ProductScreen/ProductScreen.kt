package com.example.ecommerceapp.presentation.ProductScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecommerceapp.presentation.ProductScreen.component.CenterNavBar
import com.example.ecommerceapp.presentation.ProductScreen.component.ListCard
import com.example.ecommerceapp.presentation.common.MyAppBar
import com.example.ecommerceapp.presentation.ProductScreen.component.MyPagerH
import com.example.ecommerceapp.presentation.common.MyBottomBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProductScreen(
    ViewModel: ProductScreenVIewModel = koinViewModel(),
    navController: NavHostController
) {
    val ProductItems by remember { ViewModel.productState }
    val isLoading by remember { ViewModel.isLoading }
    val isError by remember { ViewModel.isError }
    val errorMessage by remember { ViewModel.errorMessage }
    val ScrollState = rememberScrollState()



    Scaffold(
        topBar = { MyAppBar() },
        bottomBar = { MyBottomBar(navController) },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->

        when {
            isLoading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            isError -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding()), Alignment.Center
                ) {
                    Text("Error")
                    Text(errorMessage, Modifier.offset(y = 30.dp))

                }
            }

            !isLoading && ProductItems.isNotEmpty() -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        modifier = Modifier.padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding()
                        )
                    ) {
                        item(span = StaggeredGridItemSpan.FullLine) {
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(15))
                                    .fillMaxWidth()
                                    .height(300.dp)
                            ) {
                                MyPagerH()

                            }
                        }
                        item(span = StaggeredGridItemSpan.FullLine) {
                            Box(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(16.dp)
                                    .height(60.dp)
                                    .clip(RoundedCornerShape(15))
                                    .horizontalScroll(state = ScrollState),
                                Alignment.Center
                            ) {
                                CenterNavBar(vIewModel = ViewModel)
                            }
                        }

                        items(ProductItems) { product ->
                            ListCard(
                                image = product.image,
                                price = product.price,
                                rating = product.rating,
                                title = product.title
                            ) { navController.navigate("DetailScreen/${product.id}") }
                        }
                    }
                }
            }
        }
    }
}
