package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.hint)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        var index=0
        var riddleList = mutableListOf("0000，猜一句成語，:四大皆空","人有他大，天沒他大，:一","台灣女孩，猜一個字，:始","九十九，猜一個字，:白","0+0=1，猜一成語，:無中生有")
        edAnswer.text=null
        tvResult.text= null
        btnRiddle.setOnClickListener{
            val countRiddle =riddleList.count()
            index= Random.nextInt(0,countRiddle)
            val(riddle,answer)=riddleList[index].split(":")
            tvRiddle.text="謎題"+riddle
            if (index>=countRiddle){
                index=0
            }
            btnAnswer.setOnClickListener(){
                if (edAnswer.text.toString()==answer){
                    tvResult.text = "你答對了"
                }else{
                    tvResult.text = "你答錯了"
                }
            }
            btnReAnswer.setOnClickListener(){
                edAnswer.text = null
                tvResult.text = null
            }
            btnShowAnswer.setOnClickListener(){
                tvResult.text = "答案是: "+answer
            }
        }

    }
}
