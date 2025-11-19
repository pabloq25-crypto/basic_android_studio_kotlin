package com.quirozdev.androidmaster.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.dto.TaskCategory
import com.quirozdev.androidmaster.todoapp.holders.CategoryViewHolder

class CardViewAdapter(private var categoryList : List<TaskCategory>, private val onItemSelected : (Int) -> Unit) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_todo, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.render(categoryList[position],onItemSelected)
        holder.cardView.setOnClickListener { onItemSelected(position) }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}