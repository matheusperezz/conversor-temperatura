package com.example.conversordetemperatura.models.strategies

class CelsiusToKelvinStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {

        return (value + 273.15)

    }

    override fun getResultLabel(): String {
        return "K"
    }
}