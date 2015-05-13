package com.example.tim.shopping_app;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Search extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText editText = (EditText) findViewById(R.id.editTextsearch);
        final ImageButton search = (ImageButton) findViewById(R.id.imageButton6);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String item = editText.getText().toString();
                item = item.replace(" ", "%20");
                item = item.toLowerCase();
                getItem(item);

            }
        });

        final ImageButton button =  (ImageButton) findViewById(R.id.BackSearch);
        button.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {

                onBackPressed();

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getItem(String searchText) {
        AsyncTask<String, Void, List<ItemInfo>> as = new WalmartCall(this).execute(searchText);









                    }

    }







       /* try {

            final ArrayAdapter adp = new ArrayAdapter(this, R.layout.activity_results, R.id.listView, as.get());

            //final ArrayAdapter<WeatherInfo> adp = new ArrayAdapter<WeatherInfo>(this, R.layout.layout, R.id.Itemname, as.get());
            lview.setAdapter(adp);

            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    TextView textView = (TextView) view.findViewById(R.id.textView3);
                    String text = textView.getText().toString();

                    try {
                        Intent myintent = new Intent(Search.this, Results.class);
                       // ItemInfo theItem = adp.getItem(position);
                        //String info = theItem.getInfo();
                        //myintent.putExtra("info", info);
                        startActivity(myintent);
                    } //catch (Exception e) {

                    }
                }
            });
        } catch (Exception e) {
            System.out.println("getWeather");
            e.printStackTrace();
        }*/


