package com.example.conversordetemperatura

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordetemperatura.databinding.ActivityMainBinding
import com.example.conversordetemperatura.models.CalculationStrategyHolder
import com.example.conversordetemperatura.models.Calculator
import com.example.conversordetemperatura.models.strategies.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var edtDegrees: EditText
    private lateinit var spConvertions: Spinner
    private lateinit var binding: ActivityMainBinding

    private val supportedCalculationStrategies = arrayOf(
        CalculationStrategyHolder("Celsius para Fahrenheit", CelsiusToFahrenheitStrategy()),
        CalculationStrategyHolder("Celsius para Kelvin", CelsiusToKelvinStrategy()),
        CalculationStrategyHolder("Fahrenheit para Celsius", FahrenheitToCelsiusStrategy()),
        CalculationStrategyHolder("Fahrenheit para Kelvin", FahrenheitToKelvinStrategy()),
        CalculationStrategyHolder("Kelvin para Celsius", KelvinToCelsiusStrategy()),
        CalculationStrategyHolder("Kelvin para Fahrenheit", KelvinToFahrenheitStrategy()),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUi()
        setActions()

    }


    private fun setActions() {
        edtDegrees = findViewById(R.id.edtValue)
        setConvertButton(edtDegrees)
        setClearButton(edtDegrees)

    }

    private fun setClearButton(edtDegrees: EditText) {
        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener {

            edtDegrees.setText("")
            spConvertions.setSelection(0)

        }
    }

    private fun setConvertButton(edtDegrees: EditText) {
        val btnConvert: Button = findViewById(R.id.btnConvert)
        btnConvert.setOnClickListener {

            try {

                val value = edtDegrees.text.toString().toDouble()
                val calculationStrategy = supportedCalculationStrategies[
                        spConvertions.selectedItemPosition].calculationStrategy

                Calculator.setCalculationStrategy(calculationStrategy)
                val result = Calculator.calculate(value)
                val label = calculationStrategy.getResultLabel()

                showResult(result, label)


            } catch (e: NumberFormatException) {

                edtDegrees.error = "Valor não inserido"
                edtDegrees.requestFocus()

            }


        }
    }

    private fun showResult(result: Double, label: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("DEGREE", result)
        intent.putExtra("LABEL", label)
        startActivity(intent)
    }

    private fun setUi() {
        spConvertions = binding.spConvertions
        val spAdapter = ArrayAdapter(this, R.layout.list_items, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spConvertions.adapter = spAdapter
    }

    private fun getSpinnerData(): MutableList<String> {
        val spinnerData = mutableListOf<String>()
        supportedCalculationStrategies.forEach {
            spinnerData.add(it.name)
        }

        return spinnerData
    }

}