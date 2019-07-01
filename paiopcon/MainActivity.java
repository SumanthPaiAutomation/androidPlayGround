package com.example.csc.paiopcon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn.setOnCreateContextMenuListener(this);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu,view,menuInfo);
        createMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        super.onCreateOptionsMenu(menu);

        createMenu(menu);

        return onCreateOptionsMenu(menu);


    }


    public void createMenu(Menu menu){

        MenuItem item1= menu.add(0,0,0,"Dispaly All");

        MenuItem item2= menu.add(0,1,1,"Fast Dial");
    }

    public boolean onContextItemSelected(MenuItem item){

        return choiceMenu(item);
    }

    public boolean onOptionItemSelected(MenuItem item){

        return choiceMenu(item);
    }



   private boolean choiceMenu(MenuItem item){

        switch (item.getItemId()){

            case 0:
                Intent int1= new Intent(Intent.ACTION_VIEW);
            int1.setData(Uri.parse("content://contacts/people/"));
            startActivity(int1);
            return true;

            case 1:
                Intent int2= new Intent(Intent.ACTION_DIAL);
                int2.setData(Uri.parse("tel:7022524822"));
                startActivity(int2);
                return true;




        }
        return  false;



   }



}
