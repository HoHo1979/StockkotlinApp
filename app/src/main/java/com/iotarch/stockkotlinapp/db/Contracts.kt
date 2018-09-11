package com.iotarch.stockkotlinapp.db

import android.provider.BaseColumns

const val DATABASE_NAME="stock_db"
const val DATABASE_VERSION=10

//Defined the globe variable of the Stock Database Table columns and Database Name
object StockDataBase:BaseColumns{

    const val TABLE_NAME="stock_info"
    const val ID="id"
    const val STOCK_NAME="stock_name"
    const val STOCK_CODE="stock_code"
    const val STOCK_PRICE="stock_price"


}