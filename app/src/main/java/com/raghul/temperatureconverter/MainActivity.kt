package com.raghul.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var celsiusinput: EditText
    private lateinit var resulttext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.my_toolbar))


        celsiusinput = findViewById(R.id.editTextCelsius)
        resulttext = findViewById(R.id.textViewResult)
        val convertButton: Button = findViewById(R.id.buttonConvert)

        convertButton.setOnClickListener{
            convertTemperature()
        }
    }
    private fun convertTemperature(){
        val celsiustoString = celsiusinput.text.toString()

        if (celsiustoString.isNotEmpty()){
            val celsius = celsiustoString.toDouble()
            val fahrenheit = celsiustofahrenheit(celsius)
            resulttext.text = String.format("%.2f Celsius is %.2f Fahrenheit", celsius, fahrenheit)

        }else{
            resulttext.text= "Please Enter a Temperature in Celsius."
        }
    }
    private fun celsiustofahrenheit(celsius:Double):Double{
        return celsius * 9/5 +32
    }
}