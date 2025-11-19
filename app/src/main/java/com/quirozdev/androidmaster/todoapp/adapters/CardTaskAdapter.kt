package com.quirozdev.androidmaster.todoapp.adapters

import android.graphics.Paint
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
import com.quirozdev.androidmaster.todoapp.dto.TaskCategory
import com.quirozdev.androidmaster.todoapp.components.CardViewItem
import com.quirozdev.androidmaster.todoapp.dto.TaskDto
import com.quirozdev.androidmaster.todoapp.holders.TaskViewHolder

class CardTaskAdapter(var listTasks : List<TaskDto>, private val onItemSelected : (Int) -> Unit)  :
    RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_task_todo, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(listTasks[position], onItemSelected)
        holder.cbTask.setOnClickListener { onItemSelected(position) }
    }

    override fun getItemCount(): Int {
        return listTasks.size
    }
}