package com.example.csc.paisms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText txt1,txt2;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1= (EditText) findViewById(R.id.editText);
        txt2= (EditText) findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.button);
    }

    public  void sendSms(View view){

        String phoneno = txt1.getText().toString();
        String message = txt2.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneno,null,message,null,null);




    }
}
