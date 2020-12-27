package com.jay.shopping.di

import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        RoomModule::class,
        RepositoryModule::class,
    ]
)
class AppModule