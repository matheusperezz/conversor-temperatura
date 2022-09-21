package com.example.conversordetemperatura.models

import com.example.conversordetemperatura.models.strategies.CalculationStrategy

data class CalculationStrategyHolder(
    val name : String,
    val calculationStrategy: CalculationStrategy
) {}