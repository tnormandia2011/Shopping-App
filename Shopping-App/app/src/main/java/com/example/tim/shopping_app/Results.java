package com.example.tim.shopping_app;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class Results extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //String theText = extras.getString("myText");
            //int thePosition = extras.getInt("myposition");
            String theText = extras.getString("info");
            EditText editText2 = (EditText) findViewById(R.id.editText);
            //editText2.setText(String.valueOf(thePosition), TextView.BufferType.EDITABLE);
            editText2.setText(theText, TextView.BufferType.EDITABLE);
        }

        final ImageButton button =  (ImageButton) findViewById(R.id.Back);
        button.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {

                onBackPressed();

            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
          //  return true;
      //  }


       // return super.onOptionsItemSelected(item);
    }
}
