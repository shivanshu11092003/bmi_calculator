package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.get
import com.example.bmi.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kg=findViewById<TextInputEditText>(R.id.mass)
        val cm=findViewById<TextInputEditText>(R.id.height)
        val final=findViewById<TextView>(R.id.result)
        binding.calculate.setOnClickListener {
            val weight=kg.text.toString()
            val height=cm.text.toString()
            val bmi=weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))

            final.text=bmi.toString()




        }



    }
}