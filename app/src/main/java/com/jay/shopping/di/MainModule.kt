package com.jay.shopping.di

import com.jay.shopping.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainModule{

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

}