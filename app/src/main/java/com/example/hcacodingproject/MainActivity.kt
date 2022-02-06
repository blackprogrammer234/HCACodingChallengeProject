package com.example.hcacodingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hcacodingproject.adapter.ApiAdapter
import com.example.hcacodingproject.adapter.StackAdapter
import com.example.hcacodingproject.models.Question
//This import is needed to extend the other layout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_stack_list_item.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//private lateinit var binding: ActivityMainBinding
private lateinit var stackAdapter: StackAdapter
//var model : List<Question> = mutableListOf()

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //card_view_id.setOnClickListener(clickListener)
        stack_questions_list.layoutManager = LinearLayoutManager(this)
        stack_questions_list.setHasFixedSize(true)
        initRecycleView()
        addData()

        /*val binding: ViewDataBinding? = DataBindingUtil.setContentView(
            this, R.layout.layout_stack_list_item)*/
    }

    private fun onListItemClick(position: Int) {
        var card = findViewById(R.id.card_view_id) as CardView
        var questionBody = findViewById(R.id.body_question_view) as TextView

        if(questionBody.visibility == View.GONE){
            TransitionManager.beginDelayedTransition(card,AutoTransition())
            questionBody.visibility = View.VISIBLE
            Toast.makeText(this,"Expand",Toast.LENGTH_SHORT).show()

        }else {
            TransitionManager.beginDelayedTransition(card, AutoTransition())
            questionBody.visibility = View.GONE
            Toast.makeText(this,"Collapse",Toast.LENGTH_SHORT).show()
        }
    }

    private fun addData(){
        runBlocking {
            launch {
                val response = ApiAdapter.apiClient.getAllStackExchangeQuestions()
                if (response.isSuccessful && response.body() != null) {
                    //val responseBody: List<Question?> = listOf(response.body())
                    val example = response.body()!!.items
                    val list = ArrayList<Question.Item>()
                    list.addAll(example)
                    stackAdapter.submitList(list as List<Question.Item>)
                }
            }
        }
    }

    private fun initRecycleView(){
        stack_questions_list.apply {
            stack_questions_list.layoutManager = LinearLayoutManager(this@MainActivity)
            val TopSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(TopSpacingItemDecoration)
            stack_questions_list.setHasFixedSize(true)
            stackAdapter = StackAdapter{ position -> onListItemClick(position) }
            adapter = stackAdapter
        }
    }

}