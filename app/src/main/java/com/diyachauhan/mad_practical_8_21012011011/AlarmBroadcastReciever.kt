package com.diyachauhan.mad_practical_8_21012011011

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (intent!=null){
            val data = intent.getStringExtra(ALARMKEY)
            if (data!=null){
                val intentservice=Intent(context,AlarmService::class.java)
                if (data==ALARMSTART){
                    context.startService(intentservice)

                }
                else{
                    context.stopService(intentservice)
                }
            }


        }


    }
    companion object{
        val ALARMKEY="alarm"
        val ALARMSTART="start"
        val ALARMSTOP="stop"
    }
}