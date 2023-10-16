package com.example.culinarycalculator
import androidx.lifecycle.ViewModel
import com.example.culinarycalculator.data.UnitConverterData
import com.example.culinarycalculator.util.UnitConverterLogic


    class UnitConverterViewModel : ViewModel() {
        private val logic = UnitConverterLogic()
        val data = UnitConverterData()

        fun convert() {
            val inputValueText = data.inputValue.get()
            if (inputValueText.isNullOrBlank()) {
                data.outputValue.set("Valor inválido")
                return
            }

            val inputValueNumeric = inputValueText.toDoubleOrNull()
            if (inputValueNumeric == null) {
                data.outputValue.set("Valor inválido")
                return
            }

            val inputUnitIndex = data.selectedInputUnit.get()
            val outputUnitIndex = data.selectedOutputUnit.get()

            val convertedValue = logic.convert(inputValueNumeric, inputUnitIndex, outputUnitIndex)
            data.outputValue.set(String.format("%.2f", convertedValue))
        }
    }

