package com.jay.shopping.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.shopping.base.BaseViewModel
import com.jay.shopping.data.ShoppingRepository
import com.jay.shopping.model.ShoppingItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val shoppingRepository: ShoppingRepository
) : BaseViewModel() {

    var query = MutableLiveData<String>()

    private val _shoppingItems = MutableLiveData<List<ShoppingItem>>()
    val shoppingItems: LiveData<List<ShoppingItem>> get() = _shoppingItems

    private val _openDetailEvent = MutableLiveData<String>()
    val openDetailEvent: LiveData<String> get() = _openDetailEvent

    fun search() {
        val query = query.value ?: return

        shoppingRepository.getShoppingItems(query)

        shoppingRepository.getShoppingItems(query)
            .map { it.items }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { items ->
                    _shoppingItems.value = items
                }, { error ->
                    Log.e("TAG", "failed: ${error.message}")
                }
            ).addTo(disposable)
    }

    fun openDetail(link: String) {
        _openDetailEvent.value = link
    }

}