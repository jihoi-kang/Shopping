package com.jay.shopping.ui

import com.jay.shopping.R
import com.jay.shopping.base.BaseActivity
import com.jay.shopping.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class.java
)