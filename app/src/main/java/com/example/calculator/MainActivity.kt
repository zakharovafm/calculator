package com.example.calculator

import Calculator
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0:Button? = findViewById(R.id.button0)
        val button1:Button? = findViewById(R.id.button1)
        val button2:Button? = findViewById(R.id.button2)
        val button3:Button? = findViewById(R.id.button3)
        val button4:Button? = findViewById(R.id.button4)
        val button5:Button? = findViewById(R.id.button5)
        val button6:Button? = findViewById(R.id.button6)
        val button7:Button? = findViewById(R.id.button7)
        val button8:Button? = findViewById(R.id.button8)
        val button9:Button? = findViewById(R.id.button9)
        val buttonAdd:Button? = findViewById(R.id.buttonAdd)
        val buttonSub:Button? = findViewById(R.id.buttonSub)
        val buttonDiv:Button? = findViewById(R.id.buttonDiv)
        val buttonMul:Button? = findViewById(R.id.buttonMul)
        val buttonDot:Button? = findViewById(R.id.buttonDot)
        val buttonC:Button? = findViewById(R.id.buttonC)
        val buttonEqual:Button? = findViewById(R.id.buttonEqual)
        val textField:EditText? = findViewById(R.id.textField)

        var prevNum = 0f
        var currentNum = 0f

        var lastAction = ""

        button1!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "1") }

        button2!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "2") }

        button3!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "3") }

        button4!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "4") }

        button5!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "5") }

        button6!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "6") }

        button7!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "7") }

        button8!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "8") }

        button9!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + "9") }

        button0!!.setOnClickListener { textField!!.setText(textField.text.toString() + "0") }

        buttonAdd!!.setOnClickListener {
            if (textField?.text.toString() == "") {
                textField?.setText("")
            } else {
                val number = (textField?.text.toString()).toFloat()
                if (prevNum == 0f){
                    prevNum = number
                }
                else{
                    prevNum += number
                }

                lastAction = "+"
                textField?.setText("")
            }
        }

        buttonSub!!.setOnClickListener {
            if (textField?.text.toString() == "") {
                textField?.setText("")
            } else {
                val number = (textField?.text.toString()).toFloat()
                if (prevNum == 0f){
                    prevNum = number
                }
                else{
                    prevNum -= number
                }
                lastAction = "-"
                textField?.setText("")
            }
        }

        buttonMul!!.setOnClickListener {
            if (textField?.text.toString() == "") {
                textField?.setText("")
            } else {
                val number = (textField?.text.toString()).toFloat()
                if (prevNum == 0f){
                    prevNum = number
                }
                else{
                    prevNum *= number
                }
                lastAction = "*"
                textField?.setText("")
            }
        }

        buttonDiv!!.setOnClickListener {
            if (textField?.text.toString() == "") {
                textField?.setText("")
            } else {
                val number = (textField?.text.toString()).toFloat()
                if (prevNum == 0f){
                    prevNum = number
                }
                else{
                    prevNum /= number
                }
                lastAction = "/"
                textField?.setText("")
            }
        }

        buttonEqual!!.setOnClickListener {
            currentNum = textField!!.text.toString().toFloat()
            val calculator = Calculator()
            textField.setText(calculator.operation(lastAction, prevNum.toDouble(), currentNum.toDouble()).toString())
        }

        buttonC!!.setOnClickListener { textField!!.setText("") }

        buttonDot!!.setOnClickListener { textField!!.setText(textField!!.text.toString() + ".") }
    }
}