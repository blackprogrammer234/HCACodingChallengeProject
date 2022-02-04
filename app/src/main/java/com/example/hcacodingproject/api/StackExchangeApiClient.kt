package com.example.hcacodingproject.api

import com.example.hcacodingproject.models.Item
import com.example.hcacodingproject.models.Question
import retrofit2.Response
import retrofit2.http.GET

interface StackExchangeApiClient {

    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun getAllStackExchangeQuestions():Response<Question>
}