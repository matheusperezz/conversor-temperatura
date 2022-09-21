package com.example.conversordetemperatura.models.strategies

interface CalculationStrategy {

    fun calculate(value : Double) : Double

    fun getResultLabel() : String

}