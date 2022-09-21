package com.example.conversordetemperatura.models.strategies

class FahrenheitToKelvinStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {
        return ((value - 32) * 5/9 + 273.15)
    }

    override fun getResultLabel(): String {
        return "K"
    }
}