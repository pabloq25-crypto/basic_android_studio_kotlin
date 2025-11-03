package com.quirozdev.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quirozdev.androidmaster.firstapp.FirstAppActivity
import com.quirozdev.androidmaster.imccalculator.ImcActivity
import com.quirozdev.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {

    // UI
    private lateinit var btnSaludApp : Button
    private lateinit var btnImcApp : Button
    private lateinit var btnTodoApp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnSaludApp = findViewById(R.id.btnSaludApp)
        btnImcApp = findViewById(R.id.btnImcApp)
        btnTodoApp = findViewById(R.id.btnTodoApp)
    }

    private fun initListeners() {
        btnSaludApp.setOnClickListener { navigateTo(FirstAppActivity()) }
        btnImcApp.setOnClickListener { navigateTo(ImcActivity()) }
        btnTodoApp.setOnClickListener { navigateTo(TodoActivity()) }
    }

    private fun navigateTo(AppActivity : AppCompatActivity)  {
        val intent = Intent(this, AppActivity::class.java)
        startActivity(intent)
    }
}

