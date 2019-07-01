package com.example.csc.paidifftime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences("time", Context.MODE_PRIVATE);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);

        if(sharedPreferences.contains("time1Hours")){

            int Hours= sharedPreferences.getInt("time1Hours",0);
            int Minutes=sharedPreferences.getInt("time1Minutes",0);

            String time= Hours+"Hours and "+Minutes+"minutes";

            tv1.setText(time);


        }

        if(sharedPreferences.contains("time2Hours")){

            int Hours= sharedPreferences.getInt("time2Hours",0);
            int Minutes=sharedPreferences.getInt("time2Minutes",0);

            String time= Hours+"Hours and "+Minutes+"minutes";

            tv2.setText(time);


        }

        if(sharedPreferences.contains("time1Hours")&&sharedPreferences.contains("time2Hours")){

            int Hours1= sharedPreferences.getInt("time2Hours",0);
            int Minutes1=sharedPreferences.getInt("time2Minutes",0);

            int Hours2= sharedPreferences.getInt("time1Hours",0);
            int Minutes2=sharedPreferences.getInt("time3Minutes",0);

            int Hours = Math.abs(Hours1-Hours2);
            int Minutes=Math.abs(Minutes1-Minutes2);

            String time= Hours+"Hours and "+Minutes+"minutes";

            tv3.setText(time);


        }

    }

    public void sendtime1(View view){
        Intent intent1 = new Intent(this,Main2Activity.class);
        intent1.putExtra("time","1");
        startActivity(intent1);


    }

    public void sendtime2(View view){
        Intent intent2 = new Intent(this,Main2Activity.class);
        intent2.putExtra("time","2");
        startActivity(intent2);


    }



}
