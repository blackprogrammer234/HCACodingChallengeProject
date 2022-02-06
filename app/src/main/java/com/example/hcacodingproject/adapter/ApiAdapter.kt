package com.example.hcacodingproject.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hcacodingproject.R
import com.example.hcacodingproject.api.StackExchangeApiClient
import com.example.hcacodingproject.models.Question
import com.example.hcacodingproject.models.answers
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

class StackAdapter(
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var stack: List<Question.Item> = ArrayList()
    private var answer:List<answers.Item> = ArrayList()

    class StackViewHolder constructor(itemView: View, private val onItemClicked: (position: Int) -> Unit ) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val stackQuestionTitle: TextView = itemView.stack_question_title_view
        val createdBy: TextView = itemView.created_by_view
        val anwser: TextView = itemView.answer_view
        val acceptedAnswer: TextView = itemView.accepted_answer_view
        val body: TextView = itemView.body_question_view
        val answer_body: TextView = itemView.body_answer_view

        init {
            itemView.setOnClickListener(this)
        }
         fun bind(stack: Question.Item) {
            stackQuestionTitle.setText("Q: " + stack.title)
            createdBy.setText("Created by: " + stack.owner.display_name)
            anwser.setText("Answer: " + stack.answer_count)
            if (stack.is_answered) {
                acceptedAnswer.setText("Accepted Answer: 1")
            } else
                acceptedAnswer.setText("Accepted Answer: 0")
            //change this method since this depricated
            body.setText(Html.fromHtml(stack.body))

        }


        override fun onClick(p0: View?) {
            val position:Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                onItemClicked(position)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StackViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_stack_list_item, parent, false),onItemClicked
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is StackViewHolder -> {
                holder.bind(stack.get(position))
            }
        }
    }

    fun submitList(myData: List<Question.Item>) {
        stack = myData
    }

    override fun getItemCount(): Int {
        return stack.size
    }
}
interface onItemClickListener{
    fun onItemClick(position: Int)
}

/*
public suspend fun addAnswerDataBasedOnQuestionId(questionId: Int) : ArrayList<answers.Item> {
    val list = ArrayList<answers.Item>()
    val response = ApiAdapter.apiClient.getAnswerOfStackExchangeQuestionsBaswdOnId(questionId)
    if (response.isSuccessful && response.body() != null) {
        val example = response.body()!!
        list.add(example)
    }
    return list
}*/
