package com.example.culinarycalculator.data

import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData

class UnitConverterData {
    val selectedInputUnit = MutableLiveData<Int>()
    val inputValue = MutableLiveData<String>()
    val selectedOutputUnit = ObservableInt()
    val outputValue = MutableLiveData<String>()
    val calculatedValue = MutableLiveData<Double>()
}