package com.example.simpleCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleCalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            calculate { num1, num2 -> num1 + num2 }
        }

        binding.btnSubtract.setOnClickListener {
            calculate { num1, num2 -> num1 - num2 }
        }

        binding.btnMultiply.setOnClickListener {
            calculate { num1, num2 -> num1 * num2 }
        }

        binding.btnDivide.setOnClickListener {
            calculate { num1, num2 ->
                if(num2 != 0.0) num1 / num2 else Double.NaN
            }
        }
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val number1 = binding.etNumber1.text.toString().run { toDoubleOrNull() } ?: 0.0
        val number2 = binding.etNumber2.text.toString().run { toDoubleOrNull() } ?: 0.0
        val result = operation(number1, number2)
        binding.tvResult.text = "결과: $result"
    }
}