package com.quirozdev.androidmaster.todoapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.components.CardViewItem

class CardTaskAdapter(private val cardList : List<CardViewItem>)  :
    RecyclerView.Adapter<CardTaskAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_task_todo, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = cardList[position]


        holder.checkBox.setOnClickListener { view ->
            if(holder.checkBox.isChecked) {
                holder.cardView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.background_todo_app3))
            }
            else {
                holder.cardView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.purple_200))
            }
        }

        holder.checkBox.text = item.title
        holder.checkBox.buttonTintList = ContextCompat.getColorStateList(holder.itemView.context, item.colorRes!!)
        Log.i("CardTaskAdapter", "Bind item: ${item.title}")
        //holder.checkBox.setButtoT(ContextCompat.getColor(holder.itemView.context, item.colorRes!!))
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    // ViewHolder class
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = itemView.findViewById(R.id.todoCVTask)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBoxTodoTask)
    }
}