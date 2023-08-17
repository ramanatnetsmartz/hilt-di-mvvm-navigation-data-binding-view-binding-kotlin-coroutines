package com.example.di_mvvm_data_binding.network

import com.example.di_mvvm_data_binding.api.response_models.ads_listing.OtherAdsResponse
import com.example.di_mvvm_data_binding.api.response_models.register.RegisterResponse
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface ApiService {

    @GET("login")
    suspend fun login(@QueryMap data: HashMap<String, @JvmSuppressWildcards Any>): RegisterResponse


    @FormUrlEncoded
    @POST("otherAds")
    suspend fun adsListing(
        @FieldMap data: HashMap<String, @JvmSuppressWildcards Any>
    ): OtherAdsResponse
}