package com.jay.shopping.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingService {

    @GET("/v1/search/shop")
    fun getShoppingItems(
        @Query("query") query: String,
    ) : Single<ShoppingResponse>

}