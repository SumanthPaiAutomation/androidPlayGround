package com.example.csc.paiimplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDisplayAll(View view){

        Intent obj1 = new Intent(Intent.ACTION_VIEW);
        obj1.setData(Uri.parse("contents://contacts/people/"));
        startActivity(obj1);



    }

    public void onDisplaySpecific(View view){

        Intent obj2 = new Intent(Intent.ACTION_VIEW);
        obj2.setData(Uri.parse("contents://contacts/people/2"));
        startActivity(obj2);



    }

    public void onEditContact(View view){

        Intent obj3 = new Intent(Intent.ACTION_EDIT);
        obj3.setData(Uri.parse("contents://contacts/people/2"));
        startActivity(obj3);



    }

}
