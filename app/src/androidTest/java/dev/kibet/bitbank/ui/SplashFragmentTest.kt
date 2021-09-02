package dev.kibet.bitbank.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.kibet.bitbank.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashFragmentTest : TestCase(){

    @Before
    override  fun setUp() {
        FragmentScenario.launchInContainer(SplashFragment::class.java)
    }

    @Test
    fun testViewDisplayed() {
        onView(withId(R.id.image)).check(matches(isDisplayed()))
    }

}