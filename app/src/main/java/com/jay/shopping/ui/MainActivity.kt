package com.jay.shopping.ui

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jay.shopping.R
import com.jay.shopping.api.ShoppingService
import com.jay.shopping.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var shoppingService: ShoppingService

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ivSearch.setOnClickListener {
            val query = binding.etSearch.text.toString()
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

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}