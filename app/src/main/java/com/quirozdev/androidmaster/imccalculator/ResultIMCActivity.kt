package com.quirozdev.androidmaster.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quirozdev.androidmaster.R

class ResultIMCActivity : AppCompatActivity() {

    // EXTRAS
    private var EXTRA_RESULT_IMC : Double = 0.0

    // UI
    private lateinit var reCalculate : Button
    private lateinit var tvTitleResult : TextView
    private lateinit var tvResultIMC : TextView
    private lateinit var tvDescription : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        getExtras()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        reCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initComponents() {
        tvResultIMC = findViewById(R.id.tvResultIMC)
        tvTitleResult = findViewById(R.id.tvTitleResult)
        tvDescription = findViewById(R.id.tvDescription)
        reCalculate = findViewById(R.id.btnReCalculate)
    }

    private fun getExtras()  {
        EXTRA_RESULT_IMC = intent.extras?.getDouble("EXTRA_RESULT_IMC") ?: -1.0
    }


    // ALL UI
    private fun initUI() {
        showResultUI()
    }

    private fun showResultUI() {
        tvResultIMC.text = EXTRA_RESULT_IMC.toString()

        when(EXTRA_RESULT_IMC) {
            in 0.0..18.5 -> { // Low Weight
                tvTitleResult.text = getString(R.string.title_low_weight)
                tvTitleResult.setTextColor(ContextCompat.getColor(this, R.color.low_weight))
                tvDescription.text = getString(R.string.description_low_weight)

            }

            in 18.51..24.99 -> { // Normal Weight
                tvTitleResult.text = getString(R.string.title_normal_weight)
                tvTitleResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.description_normal_weight)
            }

            in 25.00..29.99 -> { // OverWeight
                tvTitleResult.text = getString(R.string.title_overweight)
                tvTitleResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvDescription.text = getString(R.string.description_overweight)
            }

            in 30.00..99.00 -> { // Obeside
                tvTitleResult.text = getString(R.string.title_obesity)
                tvTitleResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescription.text = getString(R.string.description_obesity)
            }

            else -> {
                tvTitleResult.text = getString(R.string.error)
                tvResultIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

}