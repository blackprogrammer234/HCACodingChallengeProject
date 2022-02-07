package com.example.hcacodingproject

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.hcacodingproject.adapter.ApiAdapter
import com.example.hcacodingproject.api.StackExchangeApiClient
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)

class HCACodingProjectTest {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)
    //Test is not working at the moment. Need more time to write the test correctly
    fun isStackRecycleViewDisplayedSuccessfully(){
        onView(withId(R.id.stack_questions_list)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(9))
    }

}