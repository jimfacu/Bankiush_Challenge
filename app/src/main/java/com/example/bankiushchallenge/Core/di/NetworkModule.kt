package com.example.bankiushchallenge.Core.di

import com.example.bankiushchallenge.Network.RepositoryApiClient
import com.example.bankiushchallenge.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder().
        baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRepositoryClient(retrofit: Retrofit):RepositoryApiClient{
        return retrofit.create(RepositoryApiClient::class.java)
    }
}