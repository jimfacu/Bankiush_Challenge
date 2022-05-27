package com.example.bankiushchallenge.Data

import com.example.bankiushchallenge.Models.MainScreen.Repository
import com.example.bankiushchallenge.Network.RepositoryService
import javax.inject.Inject

class RepositoriesGitHubRepository @Inject constructor( private val api:RepositoryService) {

    suspend fun getAllRepositories(perPage:Int,page:Int): Result<List<Repository>>?{
        return  api.getRepositoriesFromRS(perPage,page)
    }


}