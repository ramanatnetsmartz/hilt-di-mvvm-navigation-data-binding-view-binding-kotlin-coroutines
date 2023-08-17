package com.example.di_mvvm_data_binding.api.response_models.ads_listing

import com.example.di_mvvm_data_binding.models.ads_listing.AllOtherAd


data class OtherAdsResponse(
    val allOtherAds: ArrayList<AllOtherAd>,
    val message: String,
    val status_code: String,
    val allMyAds: ArrayList<AllOtherAd>,
    val unreadMessages: Int

)