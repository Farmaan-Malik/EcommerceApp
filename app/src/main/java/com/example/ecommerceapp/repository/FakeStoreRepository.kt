package com.example.ecommerceapp.repository

import android.util.Log
import com.example.ecommerceapp.data.remote.FakeStoreApi
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponse
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponseItem
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponse
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponseItem
import com.example.ecommerceapp.utils.Resource

class FakeStoreRepository(
    private val Api: FakeStoreApi
) {
    suspend fun getProducts(): Resource<ProductsResponse> {
        val response = try {
            Api.getProducts()
        } catch (e: Exception) {
            Log.e("RepositoryGP", "ERROR")
            return Resource.Error(message = e.localizedMessage ?: "Error in repository")
        }
        Log.e("RepositoryGP", "$response")
        return Resource.Success(data = response)

    }
    suspend fun getCategoryProducts(categoryName: String): Resource<ProductsResponse> {
        val response = try {
            Api.getCategory(categoryName = categoryName )
        } catch (e: Exception) {
            Log.e("RepositoryGCP", "${e.localizedMessage}")
            return Resource.Error(message = e.localizedMessage ?: "Error in repository")
        }
        Log.e("RepositoryGCP", "$response")
        return Resource.Success(data = response)
    }

    suspend fun getItem(id : Int): Resource<ProductsResponseItem>{
        val response = try {
            Api.getItem(id)

        } catch (e: Exception){
            Log.e("werqw", "error")
            return Resource.Error(e.localizedMessage ?: "Error in Repository")
        }
        Log.e("qwe", "${response}" )
        return Resource.Success(data = response)
    }
}