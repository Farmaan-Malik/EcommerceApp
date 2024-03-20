package com.example.ecommerceapp.presentation.ProductScreen

import android.util.Log
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponse
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponseItem
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponseItem
import com.example.ecommerceapp.presentation.ProductScreen.component.CenterNavBar
import com.example.ecommerceapp.repository.FakeStoreRepository
import com.example.ecommerceapp.utils.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class ProductScreenVIewModel(
   private val repository: FakeStoreRepository
): ViewModel(){

    private val _productState = mutableStateOf<List<ProductsResponseItem>>(listOf())
    var productState:State<List<ProductsResponseItem>> = _productState
    private val _categoryProductState = mutableStateOf<List<CategoryProductResponseItem>>(listOf())
    var categoryProductState:State<List<CategoryProductResponseItem>> = _categoryProductState
    private val _isLoading = mutableStateOf(true)
    var isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    var isError : State<Boolean> = _isError
    private val _errorMessage = mutableStateOf("")
    var errorMessage : State<String> = _errorMessage
    private var _buttonState = mutableStateOf(false)
    var buttonState: State<Boolean> = _buttonState


    init {
        getList()
    }

     private fun getList(){
        viewModelScope.launch {
            val response = repository.getProducts()
            if (response is Resource.Success && !response.data.isNullOrEmpty()){
                Log.e("ProductScreenVmSuc", response.data.toString())
                _productState.value = response.data
                _isLoading.value = false
            }else{
                _isError.value = true
                _errorMessage.value = response.message.toString()
                _isLoading.value = false
                Log.e("ProductScreenVm", response.message.orEmpty()?: "ProductScreenVM")
            }
        }
    }
     fun getCategoryList(categoryName : String){
        viewModelScope.launch {
            val response = repository.getCategoryProducts(categoryName)
            if (response is Resource.Success && !response.data.isNullOrEmpty()){
                Log.e("ProductScreenVmCat", response.data.toString())
                _categoryProductState.value = response.data
//                _isLoading.value = false
            }else{
//                _isError.value = true
//                _errorMessage.value = response.message.toString()
//                _isLoading.value = false
//                Log.e("ProductScreenVm", response.message.orEmpty()?: "ProductScreenVM")
            }
        }
    }

}

