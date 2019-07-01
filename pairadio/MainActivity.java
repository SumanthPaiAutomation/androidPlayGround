package com.example.csc.pairadio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view) {
        try { RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup7);
            int i = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(i);
            String result = radioButton.getText().toString();
            Toast.makeText(this, result + " is selected.", Toast.LENGTH_LONG).show(); }
    catch (NullPointerException e) { Toast.makeText(this, " Please Select a radioButton", Toast.LENGTH_LONG).show(); } }
}
