package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var txtvSum: TextView? = null
    var txtvDisplay: TextView? = null

    var num1 = 0.0
    var operation = 'n'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtvSum = findViewById(R.id.txtvSum)
        txtvDisplay = findViewById(R.id.txtvDisplay)

        initSetup()
    }

    private fun initSetup(){
        txtvDisplay?.setText("")
        txtvSum?.setText("")
    }

    fun numberButtons(v: View){
        //Typecasting specifying that View is a button. By doing so, we can access the properties and methods of a button
        var btn: Button = v as Button

        if(txtvDisplay!!.text.length >= 15)
            return
        else if(txtvDisplay!!.text.length >= 12)
            txtvDisplay?.textSize = 30f
        else if(txtvDisplay!!.text.length > 7)
            txtvDisplay?.textSize = 50f

        if(v.id == R.id.btnDot && txtvDisplay!!.text.indexOf(".") > -1)
            return
        else if(v.id == R.id.btnDot && txtvDisplay!!.length() <= 0)
            txtvDisplay?.append("0")

        txtvDisplay?.append(btn.text)
    }

    fun clearDelButton(v : View) {
        //We need to identify which button was clicked.
        when(v.id) {
            R.id.btnDel -> {
                txtvDisplay?.text = txtvDisplay?.text.toString().dropLast(1);
            }
            R.id.btnClear -> {
                txtvDisplay?.text = "";
            }
        }
    }

    fun operationButton(v : View) {
        var btn = v as Button

        var num2 = 0.0

        if(txtvDisplay!!.text.length > 0 && operation != 'n') {
            num1 = calculate()
        } else if(txtvDisplay!!.text.length > 0)
            num1 = txtvDisplay?.text.toString().toDouble();

        operation = btn.text[0];

        //Update the interface.
        txtvDisplay?.text = ""
        txtvSum?.text = "${num1.toString()} $operation"
    }

    fun equalsButton(v : View) {
        var num2 = txtvDisplay?.text.toString().toDouble()
        num1 = calculate()

        txtvSum?.append(" ${num2.toString()}")
        txtvDisplay?.text = num1.toString()
        operation = 'n'
    }

    private fun calculate() : Double {
        var num2 = txtvDisplay?.text.toString().toDouble()
        var ans = 0.0
        when(operation) {
            '+' -> ans = num1 + num2
            '-' -> ans = num1 - num2
            '*' -> ans = num1 * num2
            '/' -> ans = num1 / num2
        }
        return ans
    }
}