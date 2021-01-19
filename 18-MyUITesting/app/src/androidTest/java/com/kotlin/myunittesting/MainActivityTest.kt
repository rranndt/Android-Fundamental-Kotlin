package com.kotlin.myunittesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Rizki Rian Anandita
 * Create By rizki
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetCircumference() {
        onView(withId(R.id.edtLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edtWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edtHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateCircumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateCircumference)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.edtLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edtWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edtHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateVolume)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateVolume)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyVolume)))
    }

    // Penegcekan untuk empty input
    @Test
    fun assertEmptyInput() {
        // Penegcekan input untuk length
        onView(withId(R.id.edtLength)).perform(typeText(emptyInput), closeSoftKeyboard())
    }
}