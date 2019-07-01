package com.example.csc.paistudent;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4;
    Button btn1 ,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.editText);

        txt2=(EditText)findViewById(R.id.editText2);
        txt3=(EditText)findViewById(R.id.editText3);
        txt4=(EditText)findViewById(R.id.editText4);

        btn1=(Button)findViewById(R.id.button);

        btn2=(Button)findViewById(R.id.button2);


    }




    public void onInsert(View view){


        DBAdapter db = new DBAdapter(this);
        db.open();

        String name= txt1.getText().toString();
        String usn = txt2.getText().toString();
        String sem = txt3.getText().toString();
        int cgpa= Integer.parseInt(txt4.getText().toString());
        long id = db.insertStudentDetails(name,usn,sem,cgpa);
        if(id!=0){

            Toast.makeText(this,"Inserted success",Toast.LENGTH_LONG).show();


        }else{

            Toast.makeText(this,"Not Inserted",Toast.LENGTH_LONG).show();

        }

        db.close();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt4.clearFocus();
    }


    public void inSearch(View view){

        String usn = txt2.getText().toString();
        DBAdapter db = new DBAdapter(this);
        db.open();

        Cursor c= db.studentSearch(usn);

        if(c.moveToFirst()){

            display(c);

            Toast.makeText(this,"Student Found ",Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(this,"Student Not Found ",Toast.LENGTH_LONG).show();
        }

        db.close();

    }

    public void display(Cursor c){

        Toast.makeText(this, "Name :"+c.getString(0)+"usn : "+c.getString(1)+"sem  : "+c.getString(2)+"cgpa"+c.getString(3), Toast.LENGTH_SHORT).show();



    }




}
