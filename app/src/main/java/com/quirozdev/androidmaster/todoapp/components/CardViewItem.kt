package com.quirozdev.androidmaster.todoapp.components

import android.graphics.Color
import androidx.cardview.widget.CardView
import androidx.appcompat.widget.LinearLayoutCompat

class CardViewItem {
    var title : String? = null
    var colorRes : Int? = null


    constructor(title : String, colorRes : Int) {
        this.title = title
        this.colorRes = colorRes
    }
}