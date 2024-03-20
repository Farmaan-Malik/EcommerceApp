package com.example.ecommerceapp.data.remote.responses.products

data class ProductsResponseItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)