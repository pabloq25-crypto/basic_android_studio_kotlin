package com.quirozdev.androidmaster.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.adapters.CardTaskAdapter
import com.quirozdev.androidmaster.todoapp.adapters.CardViewAdapter
import com.quirozdev.androidmaster.todoapp.components.CardViewItem


class TodoActivity : AppCompatActivity() {

    private  var cardList = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other,
        TaskCategory.Other,
        TaskCategory.Other,
        TaskCategory.Other,
        TaskCategory.Other,
        TaskCategory.Other,
    )

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initRecyclerView()
    }

    private fun initComponents() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
    }

    /*private fun getListCardView(): MutableList<CardViewItem> {
        val list: MutableList<CardViewItem> = ArrayList()
        list.add(CardViewItem("Negocios", R.color.business_category))
        list.add(CardViewItem("Personal", R.color.personal_category))
        list.add(CardViewItem("Otros", R.color.personal_category))
        list.add(CardViewItem("Otrossssss", R.color.personal_category))
        list.add(CardViewItem("Otrossssss", R.color.personal_category))

        return list
    }*/


    private fun initRecyclerView() {
        // Set LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = CardViewAdapter(cardList, recyclerView2)

        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = CardTaskAdapter(cardList)
    }


}