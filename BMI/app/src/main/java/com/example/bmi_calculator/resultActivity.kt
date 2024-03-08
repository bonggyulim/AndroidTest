package com.example.bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI계산
        var value = weight / (height/100.0).pow(2.0)
        value = round(value*10)/10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value < 18.5){
            resultText = "저체중"
            resImage = R.drawable.image1
            resColor = Color.YELLOW
        } else if(value >= 18.5 && value < 23.0){
            resultText = "정상체중"
            resImage = R.drawable.image2
            resColor = Color.GREEN
        } else if(value >= 23.0 && value < 25.0){
            resultText = "과체중"
            resImage = R.drawable.image3
            resColor = Color.BLACK
        } else if(value >= 25.0 && value < 30.0){
            resultText = "경도비만"
            resImage = R.drawable.image4
            resColor = Color.CYAN
        } else if(value >= 30.0 && value < 35.0){
            resultText = "중정도비만"
            resImage = R.drawable.image5
            resColor = Color.MAGENTA
        } else{
            resultText = "고도비만"
            resImage = R.drawable.image6
            resColor = Color.RED
        }
        var tv_resvalue = findViewById<TextView>(R.id.tv_resvalue)
        var tv_restext = findViewById<TextView>(R.id.tv_restext)
        var iv_image = findViewById<ImageView>(R.id.iv_image)
        var btn_back = findViewById<Button>(R.id.btn_back)

        tv_resvalue.text = value.toString()
        tv_restext.text = resultText
        iv_image.setImageResource(resImage)
        tv_restext.setTextColor(resColor)

        btn_back.setOnClickListener{
            finish()
        }
    }
}