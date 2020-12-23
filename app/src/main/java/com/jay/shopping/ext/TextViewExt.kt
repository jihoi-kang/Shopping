package com.jay.shopping.ext

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.databinding.BindingAdapter

@Suppress("DEPRECATION")
@BindingAdapter("htmlText")
fun TextView.bindHtmlText(text: String) {
    this.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(text)
    }
}