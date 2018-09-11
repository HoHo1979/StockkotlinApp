package com.iotarch.stockkotlinapp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.iotarch.stockkotlinapp.db.StockDataBase

@Entity(tableName = StockDataBase.TABLE_NAME)
data class StockData(@PrimaryKey val id:Long,val 證券代號:String, val 證券名稱:String, val 收盤價:String){



}