package com.example.kotlinandroidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var count : Int = 0

    //onCreate is the first method of the lifecycle, executed before activity is visible.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("My Tag", "My message")

        /* this refers to our current environment, i.e: the activity.
           If this does not refer to the activity, use applicationContext().
           Use applicationContext() when this does not refer to the activity. */
        Toast.makeText(this, "Toasted Message", Toast.LENGTH_SHORT).show()
        //Toast.makeText(applicationContext(), "Toasted Message", Toast.LENGTH_SHORT).show()

        var txtv : TextView = findViewById(R.id.txtvMainText);
        txtv.text = "New text from code"; //In Kotlin, we modify via the property.
        //or... txtv.setText("New text from code")

        var btnClick : Button = findViewById(R.id.btnClick)

        btnClick.setOnClickListener({
            txtv.text = "Button clicked: ${++count}"
        });

        btnClick.setOnLongClickListener({
            Toast.makeText(this, "Button long pressed", Toast.LENGTH_SHORT).show()
            true
        })
    }
}