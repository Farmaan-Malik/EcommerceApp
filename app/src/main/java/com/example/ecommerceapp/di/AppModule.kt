package com.example.ecommerceapp.di

import com.example.ecommerceapp.data.remote.FakeStoreApi
import com.example.ecommerceapp.presentation.ProductScreen.ProductScreenVIewModel
import com.example.ecommerceapp.repository.FakeStoreRepository
import com.example.ecommerceapp.utils.Constants.BASEURL
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(FakeStoreApi::class.java) }

    factory<FakeStoreRepository> { FakeStoreRepository(get()) }

    viewModel<ProductScreenVIewModel>{
        ProductScreenVIewModel(get())

    }

}