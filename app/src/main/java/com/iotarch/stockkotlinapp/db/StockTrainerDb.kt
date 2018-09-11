package com.iotarch.stockkotlinapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//A SQLLiteHelper class that has SQL statement to create a table and Upgrade a Database
class StockTrainerDb(context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    private val SQL_CREATE_TABLE ="CREATE TABLE ${StockDataBase.TABLE_NAME} ("+
            "${StockDataBase.ID} INTEGER PRIMARY KEY ,"+
            "${StockDataBase.STOCK_CODE} TEXT ,"+
            "${StockDataBase.STOCK_NAME} TEXT ,"+
            "${StockDataBase.STOCK_PRICE} TEXT"+
            ")"

    private val SQL_DELETE_TABLE ="DROP TABLE IF EXISTS ${StockDataBase.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_TABLE)
        onCreate(db)
    }

}