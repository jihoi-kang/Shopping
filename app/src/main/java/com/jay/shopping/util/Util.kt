package com.jay.shopping.util

import java.text.DecimalFormat

object Util {

    fun getPriceWithComma(price: Long): String =
        DecimalFormat("###,###").format(price)

    fun getPriceWithComma(price: String): String =
        DecimalFormat("###,###").format(price.toLong())

}