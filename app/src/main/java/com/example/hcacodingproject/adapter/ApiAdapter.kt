package com.example.hcacodingproject.adapter

import com.example.hcacodingproject.api.StackExchangeApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {
    val apiClient: StackExchangeApiClient = Retrofit.Builder()
        .baseUrl("https://api.stackexchange.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StackExchangeApiClient::class.java)
}