package com.jay.shopping.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jay.shopping.model.ShoppingItem

@Dao
interface ShoppingItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingItems(shoppingItems: List<ShoppingItem>)

    @Query("SELECT * FROM ShoppingItem")
    fun getShoppingItems(): List<ShoppingItem>

    @Query("DELETE FROM ShoppingItem")
    fun deleteShoppingItems()

}