package com.example.bankiushchallenge.Network

import com.example.bankiushchallenge.Models.DetailScreen.DetailRepository
import com.example.bankiushchallenge.Models.MainScreen.RepositoriesContainer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoryApiClient {

    @GET("search/repositories?")
    suspend fun getRepositories(@Query("q") category:String,@Query("per_page")per_page:Int,@Query("page")page:Int): Response<RepositoriesContainer>
}