package com.rick.cheaptrip.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("bindImage")
fun setImageUrl(imageView: ImageView, url: String?){

    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}

@BindingAdapter("setPrice")
fun setPrice(textView: TextView, text: String?) {

    textView.text = "$ "+ text
}