package com.example.di_mvvm_data_binding.api.response_models.register

data class RegisterResponse(
    val message: String,
    val status_code: String,
    val userData: UserData
)