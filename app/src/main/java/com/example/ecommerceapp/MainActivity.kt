package com.example.ecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerceapp.presentation.ProductDetails.ProductDetailScreen
import com.example.ecommerceapp.presentation.ProductScreen.ProductScreen
import com.example.ecommerceapp.presentation.ui.theme.EcommerceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Home" ){
                    composable(route = "Home"){
                        ProductScreen(navController = navController)
                    }
                    composable("DetailScreen/{id}", arguments = listOf(navArgument("id"){
                        type = NavType.IntType
                    })){
                        ProductDetailScreen(id = it.arguments?.getInt("id") ?: 0, navController = navController)
                    }
                }
            }
        }
    }
}

