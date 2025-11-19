package com.quirozdev.androidmaster.todoapp.holders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.dto.TaskCategory

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val cardView: CardView = itemView.findViewById(R.id.todoViewContainer)
    val tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
    val divider : View = itemView.findViewById(R.id.divider)

    fun render(taskCategory : TaskCategory, onItemSelected: (Int) -> Unit) {


        val color = if (taskCategory.isSelected) {
            R.color.background_todo_app3
        } else {
            R.color.purple_200
        }

        cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, color))

        val currentCategory =  taskCategory.getTextCategory(taskCategory)
        val currentColor =  taskCategory.getColorCategory(taskCategory)

        tvCategoryName.text = currentCategory
        divider.setBackgroundColor(ContextCompat.getColor(divider.context, currentColor))
    }
}