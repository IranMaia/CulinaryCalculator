package com.example.culinarycalculator.util

class UnitConverterLogic {
    //Tabela de conversão  (fatores de conversão)
    private val conversionFactors = arrayOf(

        1.0,          // Gramas para Gramas
        0.03527396,   // Gramas para Onças
        0.00220462,   // Gramas para Libras
        0.001,         // Gramas para Quilogramas
        1000.0,        // Gramas para Miligramas

    //Aqui pode-se adicionar mais fatores de conversão.
    )

    fun convert(inputValue: Double, inputUnitIndex: Int, outputUnitIndex: Int): Double {
        val conversionFactor = conversionFactors[inputUnitIndex]
        return inputValue * conversionFactor
    }
}
