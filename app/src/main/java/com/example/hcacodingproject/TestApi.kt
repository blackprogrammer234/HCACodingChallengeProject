package com.example.hcacodingproject

import com.example.hcacodingproject.adapter.ApiAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        launch {
            val response = ApiAdapter.apiClient.getAllStackExchangeQuestions()
            if (response.isSuccessful && response.body() != null) {
                val responseBody = response.body()!!
                /*for(myData in responseBody.items){
                        println(myData.question_id)
                }*/
                //println(responseBody.items[0].body)
            }
        }
    }
}

