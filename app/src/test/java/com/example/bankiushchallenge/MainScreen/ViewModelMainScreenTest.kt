package com.example.bankiushchallenge.MainScreen


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.bankiushchallenge.Data.Error
import com.example.bankiushchallenge.Data.Result
import com.example.bankiushchallenge.Data.Success
import com.example.bankiushchallenge.Domain.GetRepositoriesUseCase
import com.example.bankiushchallenge.Models.DetailScreen.Owner
import com.example.bankiushchallenge.Models.MainScreen.Repository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ViewModelMainScreenTest{

    @RelaxedMockK
    private lateinit var getRepositoryUseCase:GetRepositoriesUseCase

    private lateinit var mainScreenViewModel:ViewModelMainScreen

    @get:Rule
    var  rule:InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        mainScreenViewModel = ViewModelMainScreen(getRepositoryUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }


    @Test
    fun `when the viewmodel get the first page of repositories`() = runTest{

        val myList = Success(listOf(Repository(123,"Bankiush","Bankius",4,"public", Owner("Bankiush",123)),Repository(123,"Bankiush","Bankiush",4,"public", Owner("Bankiush",123))))
        //Given
        coEvery { getRepositoryUseCase(20,1) } returns myList

        //When
        mainScreenViewModel.getRepositories()

        //then
        val myListRepo = mainScreenViewModel.repositoryList.value
        myListRepo?.equals(myList)?.let { assert(it) }

    }

    @Test
    fun `when the viewmodel get a error result`() = runTest{

        val myList = Error("ErrorMessaging")
        //Given
        coEvery { getRepositoryUseCase(20,1) } returns myList

        //When
        mainScreenViewModel.getRepositories()

        //then
        val myListRepo = mainScreenViewModel.repositoryList.value
        assert(myListRepo!!.equals(myList))
    }

    @Test
    fun `when the viewmodel refresh the page of repositories`() = runTest{


        //When
        mainScreenViewModel.getRepositoriesReset()

        //then
        assert(mainScreenViewModel.page == 2)
    }
}