package com.example.csc.paitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txt1,txt2,txt3,txt4,txt5;
    String final_str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.editText);
        txt2=(EditText)findViewById(R.id.editText2);
        txt3=(EditText)findViewById(R.id.editText3);
        txt4=(EditText)findViewById(R.id.editText4);
        txt5=(EditText)findViewById(R.id.editText5);


    }

    public void VAlidate(View view){


        String uname = txt1.getText().toString();
        String pwd = txt2.getText().toString();
        String cpwd = txt3.getText().toString();
        String phone= txt4.getText().toString();
        String email= txt5.getText().toString();

        if(txt1.getText().toString().isEmpty()|txt2.getText().toString().isEmpty()|txt3.getText().toString().isEmpty()|txt4.getText().toString().isEmpty()|txt5.getText().toString().isEmpty()){

            Toast.makeText(this,"Enter All details",Toast.LENGTH_LONG).show();


        }


        else {
         if (pwd.length() < 8) {


                Toast.makeText(this, "pwd lenght short", Toast.LENGTH_LONG).show();
            } else if (!pwd.equals(cpwd)) {

                Toast.makeText(this, "pwds not matching ", Toast.LENGTH_LONG).show();
            } else if (!email.matches("^[a-zA-Z]+[0-9a-zA-Z_]+\\@[a-z]+\\.[a-z]+")) {


                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            } else {

                for (int i = 0; i < pwd.length() - 3; i++) {

                    final_str += "*";

                }

                final_str += pwd.substring(pwd.length() - 3);

                String Result = "Name :" + uname + "\n"+"pwd :" + final_str + "\n"+"phone : " + phone + "\n"+"email : " + email + "\n";

                Toast.makeText(this, Result, Toast.LENGTH_LONG).show();


            }

        }


    }




}
