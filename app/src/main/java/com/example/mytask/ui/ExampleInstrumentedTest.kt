package com.example.mytask.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mytaskmanager.R
import com.example.mytaskmanager.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addTask_displaysInList() {
        val taskTitle = "Buy milk"
        val taskDescription = "1"


        onView(withId(R.id.btnAddTask))
            .perform(click())

        onView(withId(R.id.etTitle))
            .perform(typeText(taskTitle), closeSoftKeyboard())
        onView(withId(R.id.etDescription))
            .perform(typeText(taskDescription), closeSoftKeyboard())


        onView(withId(R.id.rbMedium))
            .perform(click())

        onView(withId(R.id.btnSave))
            .perform(click())

        onView(withId(R.id.rvTasks))
            .check(matches(hasDescendant(withText(taskTitle))))
    }

}
