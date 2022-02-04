package com.example.hcacodingproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hcacodingproject.R
import com.example.hcacodingproject.api.StackExchangeApiClient
import com.example.hcacodingproject.models.Item
import kotlinx.android.synthetic.main.layout_stack_list_item.view.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {
    val apiClient: StackExchangeApiClient = Retrofit.Builder()
        .baseUrl("https://api.stackexchange.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StackExchangeApiClient::class.java)
}

class StackAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var stack: List<Item> = ArrayList()
    class StackViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val stackQuestionTitle:TextView = itemView.stack_question_title_view
        val createdBy: TextView = itemView.created_by_view
        val anwser:TextView = itemView.answer_view
        val acceptedAnswer: TextView = itemView.accepted_answer_view

        fun bind(stack: Item){
            stackQuestionTitle.setText("Q: "+stack.title)
            createdBy.setText("Created by: " +stack.owner.display_name)
            anwser.setText("Answer: " + stack.answer_count)
            if(stack.is_answered){
                acceptedAnswer.setText("Accepted Answer: 1")
            }else
                acceptedAnswer.setText("Accepted Answer: 0")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StackViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_stack_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StackViewHolder ->{
                holder.bind(stack.get(position))
            }
        }
    }

    fun submitList(myData: List<Item>){
        stack = myData
    }

    override fun getItemCount(): Int {
        return stack.size
    }


}
