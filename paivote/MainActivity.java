package com.example.csc.paivote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void uservalidation(View view) { //EditText Variable and RadioGroup Varialble
         EditText ename = (EditText) findViewById(R.id.editText);
         RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
         //Get Data from editText and RadioGruop in form of
        String name = ename.getText().toString();
        int selectedid = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(selectedid);
       String gender = rb.getText().toString(); //Passing the Name and Gender Values to next activity using Intent (putExtra to pass values)
        Intent i = new Intent(this,Main3Activity.class);
        i.putExtra("name",name);
        i.putExtra("gender",gender);
        this.startActivity(i); }

        public void check(View view) {
        String Result = "First enter the details and click next."; //Recieving Intent Extras with the help of Bundle and Toasting it
             Bundle b = getIntent().getExtras();
             Result = b.getString("Result");
             Toast.makeText(this,Result,Toast.LENGTH_LONG).show(); }


}



