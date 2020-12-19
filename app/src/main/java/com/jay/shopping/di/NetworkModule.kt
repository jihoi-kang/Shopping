package com.jay.shopping.di

import com.jay.shopping.BuildConfig
import com.jay.shopping.api.ShoppingService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("X-Naver-Client-Id", BuildConfig.NAVER_CLIENT_ID)
                        .addHeader("X-Naver-Client-Secret", BuildConfig.NAVER_CLIENT_SECRET)
                        .build()
                )
            }.build()
    }

    @Provides
    @Reusable
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Reusable
    fun provideShoppingService(
        retrofit: Retrofit
    ): ShoppingService = retrofit.create(ShoppingService::class.java)

    companion object {
        private const val BASE_URL = "https://openapi.naver.com"
    }

}