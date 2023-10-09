package com.example.culinarycalculator
import androidx.lifecycle.ViewModel
import com.example.culinarycalculator.data.UnitConverterData
import com.example.culinarycalculator.util.UnitConverterLogic


class UnitConverterViewModel : ViewModel (){
    private val logic = UnitConverterLogic()
    private val data = UnitConverterData()

    fun convert () {
        val inputValueText = data.inputValue.get()
        if (inputValueText.isNullOrBlank()){
            data.outputValue.set("Valor Inválido")
            return
        }

        val inputValueNumeric = inputValueText.toDoubleOrNull()
        if (inputValueNumeric == null) {
            data.outputValue.set("Valor Inválido")
            return
        }

        val inputUnitIndex = data.selectInputUnit.get()
        val outputUnitIndex = data.selectedOutputUnit.get()

        val convertedValue = logic.convert(inputValueNumeric, inputUnitIndex, outputUnitIndex)
        data.outputValue.set(String.format("%.2f", convertedValue))




    }

}