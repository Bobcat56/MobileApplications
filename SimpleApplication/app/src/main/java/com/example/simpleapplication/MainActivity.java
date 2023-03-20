package com.example.simpleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Test Log", "Log Message");

        //TODO: Create some functionality.
        Toast.makeText(this, "Message", Toast.LENGTH_LONG).show();
    }
}