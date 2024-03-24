package com.example.ecommerceapp.presentation.ProductDetails

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.data.remote.responses.products.ProductsResponseItem
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponse
import com.example.ecommerceapp.data.remote.responses.products.categoryProducts.CategoryProductResponseItem
import com.example.ecommerceapp.repository.FakeStoreRepository
import com.example.ecommerceapp.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val repository: FakeStoreRepository) : ViewModel() {

    lateinit var _productItem: ProductsResponseItem
    private val _isLoading = mutableStateOf(true)
    var isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    var isError: State<Boolean> = _isError
    private val _errorMessage = mutableStateOf("")
    var errorMessage: State<String> = _errorMessage


    fun getItemVm(id: Int) {
        viewModelScope.launch {
            val response = repository.getItem(id)
            Log.e("asddsa", "${response.data}")
            if (response is Resource.Success) {
                _productItem = response.data!!
                _isLoading.value = false
                Log.e("asdasd", "${_productItem}")
            } else {
                _isError.value = true
                _isLoading.value = false
                _errorMessage.value = response.message.toString()
            }
        }
    }
}