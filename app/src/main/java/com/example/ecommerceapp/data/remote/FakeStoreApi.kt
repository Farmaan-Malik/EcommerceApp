package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.remote.responses.products.ProductsResponse
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponse
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
    ): CategoryProductResponse

}