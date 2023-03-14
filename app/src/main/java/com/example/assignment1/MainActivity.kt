package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightED : EditText = findViewById(R.id.weight)
        val heightED : EditText = findViewById(R.id.height)
        val resultTV : TextView = findViewById(R.id.result)
        val calculateBT : Button = findViewById(R.id.btCalculate)

        //Define the weight spinner with two options
        var weightFlag : String = "kg"
        val weightSpinner : Spinner = findViewById(R.id.weightSpinner)
        var weightOptions = arrayOf("kg","lb")
        weightSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,weightOptions)
        weightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                weightFlag = weightOptions.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //Define the height spinner with two options
        var heightFlag : String = "m"
        val heightSpinner : Spinner = findViewById(R.id.heightSpinner)
        var heightOptions = arrayOf("m","in")
        heightSpinner.adapter = ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,heightOptions)
        heightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                heightFlag=heightOptions.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //The button calculate implementation
        calculateBT.setOnClickListener {
            var weight : Float = weightED.text.toString().toFloat();
            var height : Float = heightED.text.toString().toFloat();

            if (weightFlag == "kg" && heightFlag == "m")
                resultTV.text = BMI1(weight,height).toString();
            else if (weightFlag == "lb" && heightFlag == "in")
                resultTV.text = BMI2(weight,height).toString();
            else
                resultTV.text = "Not compatible units for the height or the weight please try again!";

        }

    }

}

public fun BMI1(weight : Float, height : Float):Float{
    return weight / (height*height);
}

public fun BMI2(weight : Float, height : Float):Float{
    return (weight / (height*height)) * 703;
}