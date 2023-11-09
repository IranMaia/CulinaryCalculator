package com.example.culinarycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.culinarycalculator.databinding.LayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UnitConverterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: LayoutBinding = DataBindingUtil.setContentView(this, R.layout.layout)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(UnitConverterViewModel::class.java)
        binding.viewModel = viewModel

        @BindingAdapter("selectedInputUnit")
        fun setSelectedInputUnit(spinner: Spinner, viewModel: UnitConverterViewModel){
            spinner.setSelection(viewModel.data.selectedInputUnit.get())
        }

        @BindingAdapter("inputValue")
        fun setInputValue(editText: EditText, viewModel: UnitConverterViewModel) {
            editText.setText(viewModel.data.inputValue.get())
        }

        @BindingAdapter("selectedOutputUnit")
        fun setSelectedOutputUnit(spinner: Spinner, viewModel: UnitConverterViewModel) {
            spinner.setSelection(viewModel.data.selectedOutputUnit.get())
        }

        @BindingAdapter("calculatedValue")
        fun setCalculatedValue(textView: TextView, viewModel: UnitConverterViewModel) {
            textView.setText(viewModel.data.calculatedValue.toString())
        }

        setupListeners()
    }

    private fun setupListeners() {
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener {
            viewModel.convert()
        }
    }
}