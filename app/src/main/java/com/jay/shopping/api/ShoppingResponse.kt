package com.jay.shopping.api

import com.jay.shopping.model.ShoppingItem

data class ShoppingResponse(
    val display: Int,
    val items: List<ShoppingItem>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)