package com.jay.shopping.ext

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun View.bindVisible(isVisible: Boolean) {
    this.isVisible = isVisible
}