package com.jay.shopping.data

import com.jay.shopping.model.ShoppingItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingRemoteDataSource: ShoppingRemoteDataSource,
    private val shoppingLocalDataSource: ShoppingLocalDataSource,
) : ShoppingRepository {

    override fun getShoppingItems(query: String): Single<List<ShoppingItem>> {
        return shoppingRemoteDataSource.getShoppingItems(query)
            .subscribeOn(Schedulers.io())
            .map {
                val items = it.items
                shoppingLocalDataSource.insertShoppingItems(items)
                return@map items
            }
    }

    override fun getCachedShoppingItems(): List<ShoppingItem> =
        shoppingLocalDataSource.getCachedShoppingItems()

}