package com.iotarch.stockkotlinapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.iotarch.stockkotlinapp.model.StockData


class StockDbTable(context: Context){

    private val sqlHelper = StockTrainerDb(context)

    fun store(stockData: StockData): Long{

        val db = sqlHelper.writableDatabase

        val contentValue = ContentValues()
        contentValue.put(StockDataBase.ID,stockData.id)
        contentValue.put(StockDataBase.STOCK_CODE,stockData.證券代號)
        contentValue.put(StockDataBase.STOCK_NAME,stockData.證券名稱)
        contentValue.put(StockDataBase.STOCK_PRICE,stockData.收盤價)


        //1. Safe Operation on db transations

//        db.beginTransaction()
//
//        val id = try {
//
//            val returnValue = db.insert(StockDataBase.TABLE_NAME, null, contentValue)
//            db.setTransactionSuccessful()
//            return returnValue
//
//        }finally {
//            db.endTransaction()
//        }
//
//        db.close()

        //2. Transation with SQLightDatabase Extension
       val id = db.transation { db.insert(StockDataBase.TABLE_NAME, null, contentValue) }

        return id

    }



}

private inline fun <T> SQLiteDatabase.transation(function:()->T):T{

    beginTransaction()

    val result=try{

        val value=function()
        setTransactionSuccessful()
        return value
    }finally {
        endTransaction()
    }

    close()

    return result

}