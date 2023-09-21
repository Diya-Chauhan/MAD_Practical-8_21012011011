package com.diyachauhan.mad_practical_8_21012011011

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import com.google.android.material.card.MaterialCardView
import java.sql.Time

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val card= findViewById<MaterialCardView>(R.id.card_cancle)
        card.visibility=View.GONE
        val alarmbutton=findViewById<Button>(R.id.card)
        alarmbutton.setOnClickListener {
            //card.visibility=View.VISIBLE
            TimePickerDialog(this,{tp,hour,minute->setalarmtime(hour, minute)},11,0,false).show()

        }


    }
    fun setalarmtime(hour:Int,minute:Int){
        //card.visibility=View.GONE
    }
}
