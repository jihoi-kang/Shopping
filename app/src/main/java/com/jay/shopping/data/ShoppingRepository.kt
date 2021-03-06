package com.jay.shopping.data

import com.jay.shopping.model.ShoppingItem
import io.reactivex.Single

interface ShoppingRepository {

    fun getShoppingItems(query: String): Single<List<ShoppingItem>>

    fun getCachedShoppingItems(): List<ShoppingItem>

}