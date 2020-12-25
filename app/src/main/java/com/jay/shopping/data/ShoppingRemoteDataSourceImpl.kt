package com.jay.shopping.data

import com.jay.shopping.api.ShoppingResponse
import com.jay.shopping.api.ShoppingService
import io.reactivex.Single
import javax.inject.Inject

class ShoppingRemoteDataSourceImpl @Inject constructor(
    private val shoppingService: ShoppingService
) : ShoppingRemoteDataSource {

    override fun getShoppingItems(query: String): Single<ShoppingResponse> =
        shoppingService.getShoppingItems(query)

}