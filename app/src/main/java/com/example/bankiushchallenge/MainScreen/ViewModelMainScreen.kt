package com.example.bankiushchallenge.MainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankiushchallenge.Data.Result
import com.example.bankiushchallenge.Domain.GetRepositoriesUseCase
import com.example.bankiushchallenge.Models.MainScreen.Repository
import com.example.bankiushchallenge.Utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelMainScreen @Inject constructor(
    private var getRepositoriesUseCase:GetRepositoriesUseCase)
    :ViewModel() {

    val repositoryList = MutableLiveData<Result<List<Repository>>??>()


    var page =1


    fun getRepositories(){
        viewModelScope.launch {
            val result = getRepositoriesUseCase(Constants.PER_PAGE,page)
                repositoryList.value = result
            page++
        }
    }

    fun getRepositoriesReset(){
        page = 1
        getRepositories()
    }
}