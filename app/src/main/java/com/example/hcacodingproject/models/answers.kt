package com.example.hcacodingproject.models

data class answers(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
){
    data class Item(
        val answer_id: Int,
        val body: String,
        val content_license: String,
        val creation_date: Int,
        val is_accepted: Boolean,
        val last_activity_date: Int,
        val last_edit_date: Int,
        val owner: Owner,
        val question_id: Int,
        val score: Int
    ){
        data class Owner(
            val accept_rate: Int,
            val account_id: Int,
            val display_name: String,
            val link: String,
            val profile_image: String,
            val reputation: Int,
            val user_id: Int,
            val user_type: String
        )
    }

}

