package com.jay.shopping.data

import com.jay.shopping.model.ShoppingItem
import com.jay.shopping.room.ShoppingItemDao
import javax.inject.Inject

class ShoppingLocalDataSourceImpl @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao
) : ShoppingLocalDataSource {

    override fun insertShoppingItems(shoppingItems: List<ShoppingItem>) {
        shoppingItemDao.insertShoppingItems(shoppingItems)
    }

    override fun getCachedShoppingItems(): List<ShoppingItem> {
        return shoppingItemDao.getShoppingItems()
    }

}