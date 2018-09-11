package com.iotarch.stockkotlinapp.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.iotarch.stockkotlinapp.db.DATABASE_VERSION
import com.iotarch.stockkotlinapp.db.StockDataBase

@Database(entities = [(StockData::class)],version = DATABASE_VERSION)
abstract class StockDataBase: RoomDatabase() {

    abstract fun stockDao():StockDao

}