package com.example.di_mvvm_data_binding.utils.extensions

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(
    view: View,
    imageUrl: String?
) {
    val image: ImageView = view as ImageView
    val circularProgressDrawable = CircularProgressDrawable(image.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    Glide.with(image.context)
        .load(imageUrl)
        .placeholder(circularProgressDrawable)
        .into(image)
}