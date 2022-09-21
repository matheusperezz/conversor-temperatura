package com.example.conversordetemperatura.models

import com.example.conversordetemperatura.models.strategies.CalculationStrategy

object Calculator {

    private var calculationStrategy: CalculationStrategy? = null

    fun setCalculationStrategy(calculationStrategy: CalculationStrategy) {
        this.calculationStrategy = calculationStrategy
    }

    fun calculate(value : Double) : Double{

        if(calculationStrategy == null){
            throw IllegalArgumentException("Calculation strategy is not set")
        }

        return calculationStrategy!!.calculate(value)
    }

}