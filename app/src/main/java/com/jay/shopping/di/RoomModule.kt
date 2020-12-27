package com.jay.shopping.di

import android.content.Context
import androidx.room.Room
import com.jay.shopping.room.AppDatabase
import com.jay.shopping.room.ShoppingItemDao
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RoomModule {

    @Provides
    @Reusable
    fun provideAppDatabase(
        context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Shopping.db"
    )
        .allowMainThreadQueries()
        .build()

    @Provides
    @Reusable
    fun provideShoppingDao(
        appDatabase: AppDatabase
    ): ShoppingItemDao = appDatabase.shoppingItemDao()

}