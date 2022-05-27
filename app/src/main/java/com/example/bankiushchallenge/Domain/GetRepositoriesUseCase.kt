package com.example.bankiushchallenge.Domain

import com.example.bankiushchallenge.Data.RepositoriesGitHubRepository
import com.example.bankiushchallenge.Data.Result
import com.example.bankiushchallenge.Models.MainScreen.Repository
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(private val repository:RepositoriesGitHubRepository){


    suspend operator fun invoke(perPage:Int,page:Int): Result<List<Repository>>? = repository.getAllRepositories(perPage,page)


}