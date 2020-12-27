package com.jay.shopping.di

import com.jay.shopping.data.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindShoppingRepository(shoppingRepositoryImpl: ShoppingRepositoryImpl): ShoppingRepository

    @Binds
    abstract fun bindShoppingRemoteDataSource(shoppingRemoteDataSourceImpl: ShoppingRemoteDataSourceImpl): ShoppingRemoteDataSource

    @Binds
    abstract fun bindShoppingLocalDataSource(shoppingLocalDataSourceImpl: ShoppingLocalDataSourceImpl): ShoppingLocalDataSource

}