package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.remote.responses.products.ProductsResponse
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponseItem
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponse
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponseItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FakeStoreApi {

    @GET("products")
    suspend fun getProducts(
    ):ProductsResponse

    @GET("products/category/{categoryName}")
    suspend fun getCategory(
        @Path ("categoryName") categoryName:String
    ): ProductsResponse

    @GET("products/{id}")
    suspend fun getItem(
        @Path ("id") id: Int
    ): ProductsResponseItem
}