package com.example.hcacodingproject.api



import com.example.hcacodingproject.models.Question
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StackExchangeApiClient {

    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow&filter=withbody")
    suspend fun getAllStackExchangeQuestions():Response<Question>

    @GET("2.3/questions/{ids}/answers?order=desc&sort=activity&site=stackoverflow&filter=withbody")
    suspend fun getAnswerOfStackExchangeQuestionsBaswdOnId(
        @Path("ids") questionId: String
    ):Response<Question>
}