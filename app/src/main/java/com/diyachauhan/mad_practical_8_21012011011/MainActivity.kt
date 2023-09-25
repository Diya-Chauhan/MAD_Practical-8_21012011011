package com.diyachauhan.mad_practical_8_21012011011

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.android.material.card.MaterialCardView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val card=findViewById<MaterialCardView>(R.id.card_cancle)


        val alarmbutton=findViewById<Button>(R.id.clock)
        alarmbutton.setOnClickListener {
            //card.visibility=View.VISIBLE
            TimePickerDialog(this,{tp,hour,minute->setalarmtime(hour,minute)},Calendar.HOUR,Calendar.MINUTE,false).show()
        }

    }
    fun stop(){
        setalarm(-1,AlarmBroadcastReciever.ALARMSTOP)
    }
    fun setalarmtime(hour: Int, Minute: Int){
        //card.visibility=View.GONE
        val alarmtime = Calendar.getInstance()
        val year = alarmtime.get(Calendar.YEAR)
        val month = alarmtime.get(Calendar.MONTH)
        val date = alarmtime.get(Calendar.DATE)
        val minute = alarmtime.get(Calendar.MINUTE)
        val hour = alarmtime.get(Calendar.HOUR)
        alarmtime.set(year,month,date,hour,minute)
        setalarmtime(alarmtime.timeInMillis,AlarmBroadcastReciever.ALARMSTART)
    }
    fun setalarm(millitime:Long,action: String){
        val intentalarm = Intent(applicationContext,AlarmBroadcastReciever::class.java)
        intentalarm.putExtra(AlarmBroadcastReciever.ALARMKEY,action)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,4356,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        if (action == AlarmBroadcastReciever.ALARMSTART){
            if(alarmManager.canScheduleExactAlarms())
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,millitime,pendingIntent)
        }
        else if (action == AlarmBroadcastReciever.ALARMSTOP){
            alarmManager.cancel(pendingIntent)
            sendBroadcast(intentalarm)
        }
    }

}