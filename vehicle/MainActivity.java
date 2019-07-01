package com.example.csc.vehicle;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4;
    Button btn1,btn2,btn3;
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
         btn3=(Button)findViewById(R.id.button3);

    }

    public  void insert(View view){

        DBAdapter db= new DBAdapter(this);
        db.open();

        Integer num = Integer.parseInt(txt1.getText().toString());
        String name = txt2.getText().toString();
        String owner = txt3.getText().toString();
        Integer year = Integer.parseInt(txt4.getText().toString());
        long id = db.insertVehicleDetails(num,name,owner,year);

        if(id!=0){

            Toast.makeText(this,"Data Inserted succefully ",Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(this,"Data  NOT Inserted succefully ",Toast.LENGTH_LONG).show();
        }

        db.close();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt4.clearFocus();

    }

    public void search(View view){

        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c= db.getAllVehicleDetails();

        if(c.moveToFirst()){

            do{
                display(c);
            }while(c.moveToNext());

        }
        db.close();
    }

    public void display(Cursor c){

        Toast.makeText(this,"Number : "+c.getString(0)+"\n"+"Name : "+c.getString(1)+
                "\n"+"Owner : "+c.getString(2)+"\n"+"Year"+c.getString(3),Toast.LENGTH_LONG).show();

    }

    public void updateEntry(View view) {
        Integer num = Integer.parseInt(txt1.getText().toString());
        String name = txt2.getText().toString();
        String owner = txt3.getText().toString();
        Integer year = Integer.parseInt(txt4.getText().toString());
        DBAdapter db = new DBAdapter(this);
        db.open();
        if (db.updateVehicleDetails(num,name,owner,year))
            Toast.makeText(this,"Update Successful..",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_LONG).show();
        db.close();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt4.clearFocus();

    }
}
