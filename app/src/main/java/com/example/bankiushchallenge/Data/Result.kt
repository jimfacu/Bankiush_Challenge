package com.example.bankiushchallenge.Data

sealed class Result<out T : Any>
class Success<out T : Any>(val data: T) : Result<T>()
class Error(val serviceError:String) : Result<Nothing>()