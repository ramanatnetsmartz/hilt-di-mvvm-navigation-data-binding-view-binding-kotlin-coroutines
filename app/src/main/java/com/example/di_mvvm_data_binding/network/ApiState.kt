package com.example.di_mvvm_data_binding.network

sealed class ApiState {

    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success<R>(val result: R) : ApiState()
    object Empty : ApiState()
}
