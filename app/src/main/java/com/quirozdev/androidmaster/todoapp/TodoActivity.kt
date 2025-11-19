package com.quirozdev.androidmaster.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.todoapp.adapters.CardTaskAdapter
import com.quirozdev.androidmaster.todoapp.adapters.CardViewAdapter
import com.quirozdev.androidmaster.todoapp.components.CardViewItem
import com.quirozdev.androidmaster.todoapp.dto.TaskCategory
import com.quirozdev.androidmaster.todoapp.dto.TaskCategory.*
import com.quirozdev.androidmaster.todoapp.dto.TaskDto


class TodoActivity : AppCompatActivity() {

    private val listCategories = listOf(
        Business,
        Personal,
        Other,
    )

    private val listTasks = mutableListOf(
        TaskDto("Business", Business),
        TaskDto("Personal", Personal),
        TaskDto("Other", Other)
    )

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoriesAdapter: CardViewAdapter
    private lateinit var recyclerView2: RecyclerView
    private lateinit var tasksAdapter: CardTaskAdapter
    private lateinit var fabAddTask: FloatingActionButton


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
        initListeners()
        initUI()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun initComponents() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        // Set LayoutManager
        categoriesAdapter =
            CardViewAdapter(listCategories) { position -> updateCategories(position) }
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = CardViewAdapter(listCategories, { updateCategories(it) })

        tasksAdapter = CardTaskAdapter(listTasks) { onItemSelected(it) }
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {
        listTasks[position].isSelected = !listTasks[position].isSelected
        updateTasks()
    }

    // DIALOG
    private fun updateTasks() {
        /*val selectedCategories: List<TaskCategory> = listCategories.filter { it.isSelected }
        val newTasks = listTasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.listTasks = newTasks*/
        tasksAdapter.notifyDataSetChanged()
    }

    private fun updateCategories(position: Int) {
        listCategories[position].isSelected = !listCategories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.todo_dialog_plus)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                listTasks.add(TaskDto(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    // DIALOG

    /*private fun getListCardView(): MutableList<CardViewItem> {
        val list: MutableList<CardViewItem> = ArrayList()
        list.add(CardViewItem("Negocios", R.color.business_category))
        list.add(CardViewItem("Personal", R.color.personal_category))
        list.add(CardViewItem("Otros", R.color.personal_category))
        list.add(CardViewItem("Otrossssss", R.color.personal_category))
        list.add(CardViewItem("Otrossssss", R.color.personal_category))

        return list
    }*/
}