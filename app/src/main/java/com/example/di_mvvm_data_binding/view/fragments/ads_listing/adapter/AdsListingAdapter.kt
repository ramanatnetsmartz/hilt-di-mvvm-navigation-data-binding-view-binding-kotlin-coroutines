package com.example.di_mvvm_data_binding.view.fragments.ads_listing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.di_mvvm_data_binding.databinding.AdsListingItemViewBinding
import com.example.di_mvvm_data_binding.models.ads_listing.AllOtherAd

class AdsListingAdapter(
    private val adsList: List<AllOtherAd>,
    private var mContext:Context
) : RecyclerView.Adapter<AdsListingViewHolder>() {

    private lateinit var binding: AdsListingItemViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsListingViewHolder {
        binding = AdsListingItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdsListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdsListingViewHolder, position: Int) {
        val largeNews = adsList[position]
        holder.bind(largeNews)
    }

    override fun getItemCount(): Int = adsList.size

}