package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var txtnWeight : EditText? = null;
    var txtnHeight : EditText? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtnWeight = findViewById(R.id.txtnWeight);
        txtnHeight = findViewById(R.id.txtnHeight);
    }

    fun calculateBMI(weight : Double, height : Double) : Double {
        return weight / (Math.pow(height, 2.0));
    }

    fun getBMIResult(v : View) {
        var weight = txtnWeight?.text.toString().toDouble();
        var height = (txtnHeight?.text.toString().toDouble()) / 100; //Convert from centimetres to metres by dividing by 100.

        var df = DecimalFormat("#.##");
        df.roundingMode = RoundingMode.CEILING;


        var bmi : Double = df.format(calculateBMI(weight, height)).toDouble();
        Toast.makeText(applicationContext, "Your body mass index is $bmi", Toast.LENGTH_LONG).show();
    }
}