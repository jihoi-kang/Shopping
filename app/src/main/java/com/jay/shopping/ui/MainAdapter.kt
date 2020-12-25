package com.jay.shopping.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.shopping.R
import com.jay.shopping.databinding.ItemShopBinding
import com.jay.shopping.model.ShoppingItem

class MainAdapter(
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<MainViewHolder>() {

    private val shoppingItems: MutableList<ShoppingItem> = mutableListOf()

    fun setShoppingItems(shoppingItems: List<ShoppingItem>) {
        this.shoppingItems.clear()
        this.shoppingItems.addAll(shoppingItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = DataBindingUtil.inflate<ItemShopBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_shop,
            parent,
            false
        )
        return MainViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(shoppingItems[position])
    }

    override fun getItemCount(): Int = shoppingItems.size

}