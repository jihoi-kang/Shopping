package com.jay.shopping.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.shopping.api.ShoppingService
import com.jay.shopping.base.BaseViewModel
import com.jay.shopping.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val shoppingService: ShoppingService
) : BaseViewModel() {

    var query = MutableLiveData<String>()

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    private val _openDetailEvent = MutableLiveData<String>()
    val openDetailEvent: LiveData<String> get() = _openDetailEvent

    fun search() {
        val query = query.value ?: return
        shoppingService.getShopping(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _items.value = it.items
                }, { error ->
                    Log.e("TAG", "failed: ${error.message}")
                }
            ).addTo(disposable)
    }

    fun openDetail(link: String) {
        _openDetailEvent.value = link
    }

}