package com.jay.shopping.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jay.shopping.api.ShoppingService
import com.jay.shopping.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val shoppingService: ShoppingService
) : BaseViewModel() {

    var query = MutableLiveData<String>()

    fun search() {
        val query = query.value ?: return
        shoppingService.getShopping(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    it.items.forEach { item ->
                        Log.e("TAG", "${item.title}")
                    }
                }, { error ->
                    Log.e("TAG", "failed: ${error.message}")
                }
            ).addTo(disposable)
    }

}