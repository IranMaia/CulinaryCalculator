package com.example.culinarycalculator

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.culinarycalculator.data.UnitConverterData
import com.example.culinarycalculator.util.UnitConverterLogic

class UnitConverterViewModel : ViewModel() {
    private val logic = UnitConverterLogic()
    val data = UnitConverterData()

    fun convert() {
        val inputValueText = data.inputValue.value
        if (inputValueText.isNullOrBlank()) {
            data.outputValue.value = "Valor inválido"
            return
        }

        val inputValueNumeric = inputValueText.toDoubleOrNull()
        if (inputValueNumeric == null) {
            data.outputValue.value = "Valor inválido"
            return
        }

        val inputUnitIndex = data.selectedInputUnit.value ?: 0
        val outputUnitIndex = data.selectedOutputUnit.get()



        Log.d("UnitConverterViewModel", "Input Unit Index: $inputUnitIndex")
        Log.d("UnitConverterViewModel", "Output Unit Index: $outputUnitIndex")


        val convertedValue = logic.convert(inputValueNumeric, inputUnitIndex, outputUnitIndex)

        data.calculatedValue.value = convertedValue
        data.outputValue.value = String.format("%.15f", convertedValue)
    }
}

