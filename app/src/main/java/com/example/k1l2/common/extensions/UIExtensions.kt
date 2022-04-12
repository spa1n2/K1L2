package com.example.k1l2.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)


