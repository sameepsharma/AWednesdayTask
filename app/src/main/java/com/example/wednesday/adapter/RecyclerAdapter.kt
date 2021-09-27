package com.example.wednesday.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.wednesday.R
import com.example.wednesday.model.DataHolder
import org.w3c.dom.Text
import java.lang.ClassCastException

class RecyclerAdapter(
    val data: ArrayList<DataHolder>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return if (viewType==0) HeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.header_view, parent, false)
        ) else ContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_view, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            data[position].isHeader -> 0
            else -> 1
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is HeaderViewHolder -> {
                holder.headerTv.text= data[position].content
            }
            is ContentViewHolder -> {
                holder.contentTv.text=data[position].content
            }

        }

    }


    class HeaderViewHolder(val mItemView: View) : RecyclerView.ViewHolder(mItemView) {
        val headerTv = itemView.findViewById<TextView>(R.id.header_tv)

    }

    class ContentViewHolder(val conItemView: View) : RecyclerView.ViewHolder(conItemView) {
        val contentTv = conItemView.findViewById<TextView>(R.id.content_tv)
    }

}