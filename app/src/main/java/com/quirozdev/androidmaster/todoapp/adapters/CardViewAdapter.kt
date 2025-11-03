package com.quirozdev.androidmaster.todoapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.TaskCategory
import com.quirozdev.androidmaster.todoapp.components.CardViewItem

class CardViewAdapter(private var cardList : List<TaskCategory>, private val recyclerView2: RecyclerView) :
    RecyclerView.Adapter<CardViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_todo, parent, false)
        return MyViewHolder(view)
    }

    private fun initRecyclerView(list: List<TaskCategory>) {
        recyclerView2.adapter = CardTaskAdapter(list)
    }

    private fun getBackgroundColor(isComponentSelected: Boolean, holder : MyViewHolder) : Int {
        //TODO : Refactorizar

        var colorReference : Int = 0

        if (isComponentSelected) {
            colorReference = R.color.background_todo_app3
        } else {
            colorReference = R.color.purple_200
            holder.textView.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
        }

        return ContextCompat.getColor(holder.cardView.context,colorReference)
    }

    private fun initListeners(holder: MyViewHolder, item: CardViewItem, position: Int) {
        /*holder.cardView.setOnClickListener { view ->
            val filterCardList = cardList.filter { it.title == item.title }
            initRecyclerView(filterCardList)
            holder.textView.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            changeGender()
            setGenderColor(holder)
        }*/
        holder.textView.text = item.title
        holder.textView.text = item.title
        holder.colorView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, item.colorRes!!))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(cardList[position])
        //initListeners(holder, item, position)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    // ViewHolder class
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = itemView.findViewById(R.id.todoViewContainer)
        val textView: TextView = itemView.findViewById(R.id.tvCategoryName)
        val colorView : View = itemView.findViewById(R.id.divider)

        fun render(taskCategory : TaskCategory) {
            textView.text = "Ejemplo"

            when(taskCategory) {
                TaskCategory.Business -> {
                    textView.text = "Negocios"
                    colorView.setBackgroundColor(ContextCompat.getColor(colorView.context, R.color.business_category))
                }
                TaskCategory.Other ->    {
                    textView.text = "Otros"
                    colorView.setBackgroundColor(ContextCompat.getColor(colorView.context, R.color.other_category))
                }
                TaskCategory.Personal -> {
                    textView.text = "Personal"
                    colorView.setBackgroundColor(ContextCompat.getColor(colorView.context, R.color.personal_category))
                }
                else ->
                    textView.text = "Sin Categoria"
            }
        }
    // colorView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.purple_200))
    }
}