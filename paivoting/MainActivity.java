package com.example.csc.paivoting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt1;
    RadioButton rb;
    RadioGroup rg;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        txt1=findViewById(R.id.editText);


    }

    public void userValidate(View view){

        rg=findViewById(R.id.radioGroup);

        int selid = rg.getCheckedRadioButtonId();

        rb=findViewById(selid);

        String name = txt1.getText().toString();

        String gender = rb.getText().toString();

        Intent obj = new Intent(this, Main2Activity.class);
        obj.putExtra("name",name);
        obj.putExtra("gender",gender);

        startActivity(obj);



    }


    public void check(View view){

        Bundle obj1 = getIntent().getExtras();

        String Result = obj1.getString("Result");

        Toast.makeText(this,Result,Toast.LENGTH_LONG).show();


    }
}
