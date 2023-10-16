package com.example.culinarycalculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

        setupListeners()
    }

    private fun setupListeners() {
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener {
            viewModel.convert()
        }
    }
}