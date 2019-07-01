package com.example.csc.paidifftime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class Main2Activity extends AppCompatActivity {
TimePicker timePicker= (TimePicker)findViewById(R.id.timePicker);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void sendTime(View view){

        int Hours = timePicker.getHour();
        int Minutes= timePicker.getMinute();


        SharedPreferences sharedPreferences=getSharedPreferences("time", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String time = getIntent().getStringExtra("time");

        if(time.equals("1")){

            editor.putInt("time1Hour",Hours);
            editor.putInt("time1Minutes",Minutes);


        }

        else{

            editor.putInt("time2Hour",Hours);
            editor.putInt("time2Minutes",Minutes);


        }
        editor.commit();
        Intent i = new Intent(this,MainActivity.class);

        startActivity(i);


    }



}
