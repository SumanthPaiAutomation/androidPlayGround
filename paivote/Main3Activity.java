package com.example.csc.paivote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.content.Intent;
import java.util.Date;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main3Activity {

    public void ageValidation(View view) {
        String valid = ""; //Creating Variable for DatePicker and Get year from DatePicker
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        int year = datePicker.getYear(); //Get Current Date
        Date date = new Date(); //Creating String of Date
        String currentyear = date.toString(); //Get current year from Date String using SubString (i.e Last 4 numbers are year from 30-33)
        currentyear = currentyear.substring(30); //Parsing integer from Year String
        int curryear = Integer.parseInt(currentyear); //Checking the year difference between Datepicker year and Current Year
        if((curryear-year)<18) {
            valid = "Not Elgible";
        } else {
            valid = "Elgible";
        } //Formatting the result to Display in a proper Format
        Bundle b = getIntent().getExtras();
        String Result = "Name = "+b.getString("name") + "\n";
        Result = Result + "Gender = "+b.getString("gender") + "\n";
        Result = Result + "Voter is "+valid; //Intenting to MainActivity and passing the Result String
        Intent in = new Intent(this,MainActivity.class);
        in.putExtra("Result",Result);
        this.startActivity(in); }


}
