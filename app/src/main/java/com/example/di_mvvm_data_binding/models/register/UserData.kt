package com.example.di_mvvm_data_binding.api.response_models.register

data class UserData(
    val authorization_token: String,
    val city: String,
    val companyName: String,
    val deviceModal: String,
    val email: String,
    val firebaseToken: String,
    val fullName: String,
    val phoneNumber: String,
    val phoneType: Any,
    val userID: Int,
    val userType: String
)