package com.example.di_mvvm_data_binding.repository

import com.example.di_mvvm_data_binding.api.response_models.ads_listing.OtherAdsResponse
import com.example.di_mvvm_data_binding.network.ApiServiceImpl
import com.example.di_mvvm_data_binding.api.response_models.register.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun login(mHashMap: HashMap<String, Any>): Flow<RegisterResponse> = flow {
        emit(apiServiceImpl.login(mHashMap))
    }.flowOn(Dispatchers.IO)

    fun adsListing(mHashMap: HashMap<String, Any>): Flow<OtherAdsResponse> = flow {
        emit(apiServiceImpl.adsListing(mHashMap))
    }.flowOn(Dispatchers.IO)
}