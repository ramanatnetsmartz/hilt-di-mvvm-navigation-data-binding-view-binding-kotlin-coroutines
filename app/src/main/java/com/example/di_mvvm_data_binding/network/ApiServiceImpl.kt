package com.example.di_mvvm_data_binding.network


import com.example.di_mvvm_data_binding.api.response_models.ads_listing.OtherAdsResponse
import com.example.di_mvvm_data_binding.api.response_models.register.RegisterResponse
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun login(mHashMap: HashMap<String, Any>): RegisterResponse = apiService.login(mHashMap)
    suspend fun adsListing(mHashMap: HashMap<String, Any>): OtherAdsResponse = apiService.adsListing(mHashMap)
}