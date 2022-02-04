package com.example.hcacodingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hcacodingproject.databinding.ActivityMainBinding
//This import is needed to extend the other layout
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stack_questions_list.layoutManager = LinearLayoutManager(this)
        stack_questions_list.setHasFixedSize(true)

        val binding: ViewDataBinding? = DataBindingUtil.setContentView(
            this, R.layout.layout_stack_list_item)


    }
}