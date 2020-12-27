package com.jay.shopping.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jay.shopping.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shoppingItemDao(): ShoppingItemDao

}