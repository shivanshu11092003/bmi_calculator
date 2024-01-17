package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
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

            val a= String.format("%.2f",bmi).toFloat()

            final.text=a.toString()

            colour(bmi)




        }



    }

    private fun colour(bmi: Float) {
        val bmitext=findViewById<TextView>(R.id.Colour)

        var finaltext=""
        var color = 0
        when{
            bmi>=30 ->{
                finaltext="Obese"
                color=R.color.red
            }
            bmi in 25.0..29.99 ->{
                finaltext = "Overweight"
                color=R.color.orange

            }
            bmi in 18.5..24.0 ->{
                finaltext="Normal"
                color=R.color.Green
            }
            bmi<18.5 ->{
                finaltext="UnderWeight"
                color=R.color.yellow
            }

        }
        bmitext.setTextColor(ContextCompat.getColor(this,color))
        bmitext.text=finaltext


    }
}