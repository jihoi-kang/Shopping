package com.jay.shopping.data

import com.jay.shopping.api.ShoppingResponse
import io.reactivex.Single
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingRemoteDataSource: ShoppingRemoteDataSource
) : ShoppingRepository {

    override fun getShoppingItems(query: String): Single<ShoppingResponse> =
        shoppingRemoteDataSource.getShoppingItems(query)

}