package dev.kibet.bitbank.ui.home.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashViewModelTest : TestCase() {
    @Mock
    lateinit var splashViewModel:SplashViewModel

    @Before
    override fun setUp(){
        splashViewModel = SplashViewModel()
    }

    @Test
    fun testIfNavigationIsWorking() = runBlocking {
        try{
            splashViewModel.setSplashTimeout(true)

            splashViewModel.getSplashTimeout().apply {
                //test assert functionality
            }

        }catch (exception: Exception){
            fail()
        }
    }

}