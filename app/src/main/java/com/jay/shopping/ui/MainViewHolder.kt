package com.jay.shopping.ui

import androidx.recyclerview.widget.RecyclerView
import com.jay.shopping.BR
import com.jay.shopping.databinding.ItemShopBinding
import com.jay.shopping.model.Item

class MainViewHolder(
    private val binding: ItemShopBinding,
    private val mainViewModel: MainViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        with(binding) {
            setVariable(BR.viewModel, mainViewModel)
            setVariable(BR.item, item)
            executePendingBindings()
        }
    }

}