package com.iotarch.stockkotlinapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class StockRecycleViewAdpter(val stocks: List<StockData>):RecyclerView.Adapter<StockRecycleViewAdpter.StockRecyclerHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockRecyclerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_stock,parent,false)
        return StockRecyclerHolder(view)
    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    override fun onBindViewHolder(holder: StockRecyclerHolder, position: Int) {

        val stock=stocks.get(position)
        holder.bind(stock)

    }


    inner class StockRecyclerHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){


        fun bind(stock: StockData) {
            code?.setText(stock.證券代號)
            name?.setText(stock.證券名稱)
            price?.setText(stock.收盤價)
        }

        val code = itemView?.findViewById<TextView>(R.id.codeTV)
        val name = itemView?.findViewById<TextView>(R.id.nameTV)
        val price = itemView?.findViewById<TextView>(R.id.priceTV)


    }


}