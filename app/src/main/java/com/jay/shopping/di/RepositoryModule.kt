package com.jay.shopping.di

import com.jay.shopping.data.ShoppingRemoteDataSource
import com.jay.shopping.data.ShoppingRemoteDataSourceImpl
import com.jay.shopping.data.ShoppingRepository
import com.jay.shopping.data.ShoppingRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindShoppingRepository(shoppingRepositoryImpl: ShoppingRepositoryImpl): ShoppingRepository

    @Binds
    abstract fun bindShoppingRemoteDataSource(shoppingRemoteDataSourceImpl: ShoppingRemoteDataSourceImpl): ShoppingRemoteDataSource

}