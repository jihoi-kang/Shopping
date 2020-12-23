package com.jay.shopping.ext


import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("onEditorAction")
fun EditText.bindOnEditorAction(search: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            search.invoke()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}