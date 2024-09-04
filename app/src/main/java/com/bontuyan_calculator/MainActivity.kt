package com.bontuyan_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)

        findViewById<Button>(R.id.addButton).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.subtractButton).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.multiplyButton).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.divideButton).setOnClickListener { calculate('/') }
    }

    private fun calculate(operation: Char) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val resultValue = when (operation) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> if (num2 != 0.0) num1 / num2 else "Error"
                else -> "Error"
            }
            result.text = String.format("%.2f", resultValue)
        } else {
            result.text = "Invalid Input"
        }
    }
}