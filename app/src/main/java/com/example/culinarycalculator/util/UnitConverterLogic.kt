package com.example.culinarycalculator.util

import android.util.Log

class UnitConverterLogic {
    // Tabela de conversão (fatores de conversão)
    private val conversionFactors = arrayOf(
        doubleArrayOf(
            1.0,
            2.2046,
            35.27396,
            1000.0,
            1000000.0
        ),  // Quilogramas para outras unidades
        doubleArrayOf(0.4535923, 1.0, 16.0, 453.59, 453592.37), // Libras para outras unidades
        doubleArrayOf(
            0.028349523125,
            0.0625,
            1.0,
            28.349523125,
            28349.523125
        ), // Onças para outras unidades
        doubleArrayOf(0.001, 0.00220462, 0.03527396, 1.0, 1000.0),  // Gramas para outras unidades
        doubleArrayOf(
            0.000001,
            0.00000220462,
            0.00003527396,
            0.001,
            1.0
        )  // Miligramas para outras unidades
    )

    fun convert(inputValue: Double, inputUnitIndex: Int, outputUnitIndex: Int): Double {
        if (inputUnitIndex < 0 || inputUnitIndex >= conversionFactors.size) return 0.0
        if (outputUnitIndex < 0 || outputUnitIndex >= conversionFactors.size) return 0.0

        // Compara o tamanho das unidades
        val unitSizeCompare =
            conversionFactors[inputUnitIndex][0] / conversionFactors[outputUnitIndex][0]

        // Determina a direção da operação
        if (unitSizeCompare > 1.0) {
            // Multiplica pelo fator de conversão
            return inputValue * conversionFactors[inputUnitIndex][outputUnitIndex]
        } else {
            // Divide pelo fator de conversão
            return inputValue * conversionFactors[inputUnitIndex][outputUnitIndex]
        }
    }

}

