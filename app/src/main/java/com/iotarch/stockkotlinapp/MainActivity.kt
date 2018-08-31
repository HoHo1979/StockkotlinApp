package com.iotarch.stockkotlinapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
//https://quality.data.gov.tw/dq_download_json.php?nid=11549&md5_url=bb878d47ffbe7b83bfc1b41d0b24946e
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.stockRecycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)



        fab.setOnClickListener { view ->

            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("https://quality.data.gov.tw/dq_download_json.php?nid=11549&md5_url=bb878d47ffbe7b83bfc1b41d0b24946e")
                    .build()

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call?, e: IOException?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call?, response: Response?) {
                    val responseData:String?= response?.body()?.string()
                    val stockType = object:TypeToken<List<StockData>>(){}.type
                    val stocks: ArrayList<StockData> = Gson().fromJson(responseData,stockType)

                    for (stock in stocks) {

                        Log.d("MainActivity",stock.證券名稱)
                    }
                    

                    runOnUiThread(){

                        recyclerView.adapter = StockRecycleViewAdpter(stocks)
                        recyclerView.adapter.notifyDataSetChanged()

                    }


                }
            })
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
