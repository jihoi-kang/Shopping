package com.jay.shopping.data

import com.jay.shopping.model.ShoppingItem

interface ShoppingLocalDataSource {

    fun insertShoppingItems(shoppingItems: List<ShoppingItem>)

    fun getCachedShoppingItems(): List<ShoppingItem>

}