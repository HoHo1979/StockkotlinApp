package com.iotarch.stockkotlinapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.BaseColumns
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.iotarch.stockkotlinapp.db.StockDbTable
import com.iotarch.stockkotlinapp.model.StockData

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

//https://quality.data.gov.tw/dq_download_json.php?nid=11549&md5_url=bb878d47ffbe7b83bfc1b41d0b24946e
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        stockRecycler.setHasFixedSize(true)
        stockRecycler.layoutManager = LinearLayoutManager(this)

    //Test the code and insert the data by using SQLiteHelper
//        val stock1 = StockData(1,"0001","恭喜","10.1")
//
//        val id = StockDbTable(this).store(stock1)
//
//        Log.d("MainActivity","this is the id ${id}")
//
//         val stock2 = StockData(2,"0002","發財","12.1")
//
//        val id2 = StockDbTable(this).store(stock2)
//
//         Log.d("MainActivity","this is the id ${id2}")

//        val viewModel = ViewModelProviders.of(this).get(StockModel::class.java)
//        viewModel.loadStocks().observe(this, Observer {stockList->
//                if(stockList!=null) {
//                    runOnUiThread() {
//                        stockRecycler.adapter = StockRecycleViewAdpter(stockList)
//                        stockRecycler.adapter.notifyDataSetChanged()
//                    }
//                }
//            })


    fab.setOnClickListener { view ->

//            val client = OkHttpClient()
//            val request = Request.Builder()
//                    .url("https://quality.data.gov.tw/dq_download_json.php?nid=11549&md5_url=bb878d47ffbe7b83bfc1b41d0b24946e")
//                    .build()
//
//            client.newCall(request).enqueue(object :Callback{
//                override fun onFailure(call: Call?, e: IOException?) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onResponse(call: Call?, response: Response?) {
//                    val responseData:String?= response?.body()?.string()
//                    val stockType = object:TypeToken<List<StockData>>(){}.type
//                    val stocks: ArrayList<StockData> = Gson().fromJson(responseData,stockType)
//
//                    for (stock in stocks) {
//
//                        Log.d("MainActivity",stock.證券名稱)
//                    }
//
//
//                    runOnUiThread(){
//
//                        recyclerView.adapter = StockRecycleViewAdpter(stocks)
//                        recyclerView.adapter.notifyDataSetChanged()
//
//                    }
//
//
//                }
//            })



        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
