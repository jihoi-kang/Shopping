package com.jay.shopping.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.jay.shopping.R
import com.jay.shopping.base.BaseActivity
import com.jay.shopping.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private val mainAdapter: MainAdapter by lazy {
        MainAdapter(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvItemList.adapter = mainAdapter
    }

    private fun setupObserve() {
        viewModel.shoppingItems.observe(this) { items ->
            mainAdapter.setShoppingItems(items)
        }
        viewModel.openDetailEvent.observe(this) { link ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        }
    }

}