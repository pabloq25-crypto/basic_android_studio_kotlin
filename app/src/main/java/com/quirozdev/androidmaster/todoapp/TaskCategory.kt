package com.quirozdev.androidmaster.todoapp

sealed class TaskCategory {
    object Business : TaskCategory()
    object Personal : TaskCategory()
    object Home : TaskCategory()
    object Finance : TaskCategory()
    object Other : TaskCategory()
}