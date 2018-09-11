package com.iotarch.stockkotlinapp.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.iotarch.stockkotlinapp.db.DATABASE_NAME

@Dao
interface StockDao {

//    @get:Query("SELECT * FROM ${DATABASE_NAME}")
//    val selectAllStock : List<StockData>


    @Insert
    fun insertStockAll(stock:List<StockData>)

}