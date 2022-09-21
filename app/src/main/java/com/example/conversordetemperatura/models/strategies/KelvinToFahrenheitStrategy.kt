package com.example.conversordetemperatura.models.strategies

class KelvinToFahrenheitStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {
        return ((value - 273.15) * (9/5) + 32)
    }

    override fun getResultLabel(): String {
        return "ºF"
    }
}