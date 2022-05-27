package com.example.bankiushchallenge.Network

import com.example.bankiushchallenge.Data.Error
import com.example.bankiushchallenge.Data.Result
import com.example.bankiushchallenge.Data.Success
import com.example.bankiushchallenge.Models.MainScreen.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryService @Inject constructor(private val api:RepositoryApiClient) {


    suspend fun getRepositoriesFromRS(perPage:Int,page:Int): Result<List<Repository>>? {
        return withContext(IO) {
            val response =
               api.getRepositories("kotlin", perPage, page)

            if (response.isSuccessful) {
                response.body()?.let { Success(it.items) }
            } else {
                Error("Failed Service")
            }
        }
    }
}