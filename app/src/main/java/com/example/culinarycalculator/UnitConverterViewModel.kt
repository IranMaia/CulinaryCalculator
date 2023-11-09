package com.example.culinarycalculator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.culinarycalculator.data.UnitConverterData
import com.example.culinarycalculator.util.UnitConverterLogic


    class UnitConverterViewModel : ViewModel() {
        private val logic = UnitConverterLogic()
        val data = UnitConverterData()

        private val _calculatedValue = MutableLiveData<Double>()
        val calculatedValue: LiveData<Double> get() = _calculatedValue

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

            // Converta o valor de entrada para a unidade de saída
            val convertedValue = logic.convert(inputValueNumeric, inputUnitIndex, outputUnitIndex)

            // Defina o valor calculado
            _calculatedValue.value = convertedValue

            // Atualize o valor de saída
            data.outputValue.set(String.format("%.2f", convertedValue))
        }
    }

