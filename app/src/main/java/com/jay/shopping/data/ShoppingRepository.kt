package com.jay.shopping.data

import com.jay.shopping.api.ShoppingResponse
import io.reactivex.Single

interface ShoppingRepository {

    fun getShoppingItems(query: String): Single<ShoppingResponse>

}