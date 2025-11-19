package com.quirozdev.androidmaster.todoapp.dto

import com.quirozdev.androidmaster.R

sealed class TaskCategory(var isSelected: Boolean = false) {
    object Business : TaskCategory()
    object Personal : TaskCategory()
    object Other : TaskCategory()

    fun getColorCategory(taskCategory : TaskCategory) : Int {
        return when (taskCategory) {
            Business -> R.color.business_category
            Other -> R.color.other_category
            Personal -> R.color.personal_category
        }
    }

    fun getTextCategory(taskCategory : TaskCategory) : String {
        return when (taskCategory) {
            Business -> "Negocios"
            Other -> "Otros"
            Personal -> "Personal"
        }
    }

}