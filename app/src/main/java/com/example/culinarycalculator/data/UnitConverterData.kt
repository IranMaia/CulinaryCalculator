package com.example.culinarycalculator.data

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UnitConverterData {
    val selectedInputUnit = ObservableInt(0)//Unidadr padrão de entrada(ex: gramas).
    val inputValue = ObservableField<String>("")//valor de entrada.

    val selectedOutputUnit = ObservableInt(1)//Unidade de saída padrão(ex: Onça).
    val outputValue = ObservableField<String>("")//Valor de saída.

    val calculatedValue: LiveData<Double> = MutableLiveData()
}