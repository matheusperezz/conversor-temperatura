package com.example.conversordetemperatura.models.strategies

class FahrenheitToCelsiusStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {
        return ((value - 32) * 5/9)
    }

    override fun getResultLabel(): String {
        return "ºC"
    }
}