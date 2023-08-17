package com.example.di_mvvm_data_binding.view.fragments.ads_listing.adapter


import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.di_mvvm_data_binding.R
import com.example.di_mvvm_data_binding.databinding.AdsListingItemViewBinding
import com.example.di_mvvm_data_binding.models.ads_listing.AllOtherAd

class AdsListingViewHolder(
    private val binding: AdsListingItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(adItem: AllOtherAd) {
        binding.adsListingItem = adItem
        binding.textViewStatus
        if (adItem.itemStatus.equals(
                binding.root.context.getString(R.string.available),
                true
            )
        ) {
            binding.textViewStatus.setTextColor(binding.root.context.getColor(R.color.green_color))
        } else {
            binding.textViewStatus.setTextColor(Color.RED)
        }
    }
}