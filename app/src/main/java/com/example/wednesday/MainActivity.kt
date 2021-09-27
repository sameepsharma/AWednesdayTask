package com.example.wednesday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wednesday.adapter.RecyclerAdapter
import com.example.wednesday.model.DataHolder

class MainActivity : AppCompatActivity() {

    lateinit var rvMain : RecyclerView

    val dataToRender = arrayListOf<DataHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val headerOne = DataHolder(true, "Alphabets")
        dataToRender.add(headerOne)

        CharRange('A', 'Z').forEach { char ->

            dataToRender.add(DataHolder(false, char.toString()))

        }

        val headerTwo = DataHolder(true, "Numbers")
        dataToRender.add(headerTwo)

        for (i in 1..50)
            dataToRender.add(DataHolder(false, i.toString()))


        rvMain = findViewById(R.id.rv_main)
        rvMain.layoutManager=LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvMain.adapter = RecyclerAdapter(dataToRender)

    }
}