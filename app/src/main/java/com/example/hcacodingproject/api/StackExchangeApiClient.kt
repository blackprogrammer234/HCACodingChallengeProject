package com.example.hcacodingproject.api

import com.example.hcacodingproject.models.question
import retrofit2.Response
import retrofit2.http.GET

interface StackExchangeApiClient {

    @GET("/2.3/answers/70979122?order=desc&sort=activity&site=stackoverflow&filter=withbody")
    suspend fun getAllStackExchangeQuestions():Response<question>
}