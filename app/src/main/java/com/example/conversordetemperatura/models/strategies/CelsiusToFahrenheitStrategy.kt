package com.example.conversordetemperatura.models.strategies

class CelsiusToFahrenheitStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {

        return ((value*(9/5)) + 32)

    }

    override fun getResultLabel(): String {
        return "ºF"
    }
}