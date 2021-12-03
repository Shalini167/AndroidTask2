package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCount= mutableMapOf<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickCountDisplayView=findViewById<TextView>(R.id.clickCountView)
        val clickMeButton=findViewById<TextView>(R.id.clickButton)
        val textinput=findViewById<TextInputLayout>(R.id.inputtext)
        clickMeButton.setOnClickListener{
            val name=textinput.editText?.text?.toString()

            val maskedname=
                if(name.isNullOrEmpty()) "Somebody"
                else name

            val oldClickCount=clickCount[maskedname]?:0
            val newClickCount=oldClickCount+1
            clickCount[maskedname]=newClickCount
            clickCountDisplayView.text=(" $maskedname Clicked $newClickCount times")
        }
    }
}