package com.example.culinarycalculator.data

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class UnitConverterData {
    val selectInputUnit = ObservableInt(0)//Unidadr padrão de entrada(ex: gramas).
    val inputValue = ObservableField<String>("")//valor de entrada.

    val selectedOutputUnit = ObservableInt(1)//Unidade de saída padrão(ex: Onça).
    val outputValue = ObservableField<String>("")//Valor de saída.
}