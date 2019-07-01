package com.example.csc.paimenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =(Button)findViewById(R.id.button);
        btn.setOnCreateContextMenuListener(this);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu,v,menuInfo);
        CreateMenu(menu);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return onCreateOptionsMenu(menu);
    }


    private void CreateMenu(Menu menu){

        MenuItem item1= menu.add(0,0,0,"Dispaly All");

        MenuItem ttem2= menu.add(0,0,1,"Fast Dial");





    }

    public boolean onContextMenuSelectedItem(MenuItem item){

     return   MenuChoice(item);

    }

    public boolean onOptionsMenuSelectedItem(MenuItem item){

        return MenuChoice(item);
    }


    private boolean MenuChoice(MenuItem item){


        switch (item.getItemId()){

            case 0:
                Intent intent1=new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("content://contacts/people/"));
                startActivity(intent1);
                return true;
            case 1:
                Toast.makeText(this, "Fast Dialing to +7022524822", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:+919824537234"));
                startActivity(intent2);
                return true;
        }
        return false;



    }


    }


