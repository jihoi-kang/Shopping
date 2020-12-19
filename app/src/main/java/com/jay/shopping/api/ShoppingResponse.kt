package com.jay.shopping.api

import com.jay.shopping.model.Item

data class ShoppingResponse(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)