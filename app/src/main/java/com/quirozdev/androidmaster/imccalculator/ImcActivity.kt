package com.quirozdev.androidmaster.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import com.quirozdev.androidmaster.R
import com.quirozdev.androidmaster.firstapp.ResultActivity

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 27
    private var currentHeight: Int = 120

    private lateinit var tvHeight: TextView
    private lateinit var tvWeight: TextView
    private lateinit var tvAge:TextView
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var rsHeight: Slider
    private lateinit var btnSubstractWeight : FloatingActionButton
    private lateinit var btnPlusWeight : FloatingActionButton
    private lateinit var btnSubstractAge : FloatingActionButton
    private lateinit var btnPlusAge : FloatingActionButton
    private lateinit var btnCalculate : Button

    companion object {
        const val IMC_KEY = "EXTRA_RESULT_IMC"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListiners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListiners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df : DecimalFormat = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight CM"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setAgeWeight(true)
        }
        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setAgeWeight(true)
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAgeWeight(false)
        }
        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAgeWeight(false)
        }
        btnCalculate.setOnClickListener {
            val resultIMC : Double =  calculateIMC()
            navigateToResult(resultIMC)
                // Log.i("PabloDevs","Button Pulsado $name")
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }


    private fun calculateIMC() : Double {
        val df = DecimalFormat("#.##")
        val currentHeighToM = currentHeight.toDouble() / 100
        val imc : Double = currentWeight.toDouble() / (currentHeighToM.toDouble() * currentHeighToM.toDouble())
        return df.format(imc).toDouble()
    }

    private fun setAgeWeight(isWeight : Boolean) {
        if(isWeight) {
            tvWeight.text = currentWeight.toString()
        } else {
            tvAge.text = currentAge.toString()
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun  setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isComponentSelected: Boolean) : Int {
        val colorReference = if (isComponentSelected) {
            R.color.background_component_selected
        } else {
            R.color.backgroud_component
        }

        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}