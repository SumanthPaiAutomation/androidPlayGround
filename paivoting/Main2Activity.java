package com.example.csc.paivoting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    DatePicker datePicker=(DatePicker) findViewById(R.id.datePicker);
    Button btn1=(Button)findViewById(R.id.button);

    String Valid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public  void onValidate(View view){

        int year = datePicker.getYear();


        Date date= new Date();

        String currentyear= date.toString();

        currentyear= currentyear.substring(30);

        int curryear= Integer.parseInt(currentyear);

        if((curryear-year)<18){

            Valid = "Voter is Eligible";

        }else
        {

            Valid= "Not Eligible";
        }

        Bundle obj = getIntent().getExtras();
        String Result= "Name : "+obj.get("name")+"gender :"+obj.get("gender")+"Elgibilty : "+Valid;

        Intent int1= new Intent(this,MainActivity.class);
        int1.putExtra("Result",Result);

        startActivity(int1);


    }





}
