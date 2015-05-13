package com.example.tim.shopping_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class History extends ActionBarActivity {

    String[] mainString = new String[101];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        final ImageButton back = (ImageButton) findViewById(R.id.imageButton2);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                onBackPressed();


            }
        });

        //EditText editText2 = (EditText) findViewById(R.id.editText2);

        //editText2.setText(theText, TextView.BufferType.EDITABLE);
        final Button write = (Button) findViewById(R.id.button3);
        write.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              /* mainString[100] = "0";
               // mainString[0] = ("Test1");
               //mainString[1] = ("Test2");
                //mainString[2] = ("Test3");
               // mainString[3] = ("Test4");
                //mainString[4] = ("Test5");
                //mainString[5] = ("Test6");
                //mainString[100] = ("6");
               mainString = Methods.setMain(mainString, "Test1");
               mainString = Methods.setMain(mainString, "Test2");
               mainString = Methods.setMain(mainString, "Test3");
               mainString = Methods.setMain(mainString, "Test4");
               mainString = Methods.setMain(mainString, "Test5");

                writeHistory(mainString, makeFileKey("testUser"));*/
                WriteFile("test", "testUser");




            }
        });
        final Button read = (Button) findViewById(R.id.button4);
        read.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
/*
                mainString = ReadHistory("testUser");

                String stringy;
                for(int i = 0; i<Integer.parseInt(mainString[100]); i++)
                {
                    stringy = mainString[i];
                    EditText editText2 = (EditText) findViewById(R.id.editText2);

                    editText2.setText(stringy, TextView.BufferType.EDITABLE);
                }

                */
                String stringy = ReadFile("testUser");
                EditText editText2 = (EditText) findViewById(R.id.editText2);

                editText2.setText(stringy, TextView.BufferType.EDITABLE);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
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
    public void WriteFile(String string, String fileName)
    {
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e){

            e.printStackTrace();
        }
    }


    public String ReadFile(String fileName)
    {
        String temp = "";
        try
        {
            FileInputStream fin = openFileInput(fileName);
            int c;
            while ((c=fin.read()) != -1)

            {
                temp = temp + Character.toString((char) c);
            }
            fin.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            return temp;
        }


    }
    public String[] ReadHistory(String userName)
    {//start readHistory
        String[] historyArray= new String[101];
        String temp = "";
        int arraySlot = 0;
        String fileKey = makeFileKey(userName);

        try
        {
            FileInputStream fin = openFileInput(userName + "userHistory");
            int c;
            while ((c=fin.read()) != -1)

            {
                temp = temp + Character.toString((char) c);

                if (temp.indexOf(fileKey) != -1)
                {
                    historyArray[arraySlot] = temp.substring(0,(temp.length() - 11));
                    temp = "";
                    arraySlot++;
                }
            }
            fin.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            arraySlot++;
            historyArray[100] =  Integer.toString(arraySlot);
            return historyArray;
        }

    }//end readHistory







    public void writeHistory(String mainString[], String userName)
    {//start writeHistory

        FileOutputStream outputStream;
        String workString = "";
        int currentSize = Integer.parseInt(mainString[100]);
        String fileKey = makeFileKey(userName);

        for (int i = 0; i < currentSize; i++)
        {
            workString += (mainString[i] + fileKey);
        }

        try
        {
            outputStream = openFileOutput((userName + "userHistory"), Context.MODE_PRIVATE);
            outputStream.write(workString.getBytes());
            outputStream.close();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }//end writeHistory
    public static String makeFileKey(String userName)
    {//start makeFileKey
        char[] charArray = userName.toCharArray();
        String keyOut = "";
        int counter = 1;

        for(char c : charArray)
        {//start foreach
            keyOut+= c;
            if(counter % 2 == 0)
            {
                keyOut+= "@";
            }

            else if(counter % 3 == 0)
            {
                keyOut+= "#";
            }

            else if(counter % 4 == 0)
            {
                keyOut+= "$";
            }

            else if(counter % 5 == 0)
            {
                keyOut+= "%";
            }

            else if(counter % 6 == 0)
            {
                keyOut+= "^";
            }

            else if(counter % 7 == 0)
            {
                keyOut+= "&";
            }

            else if(counter % 8 == 0)
            {
                keyOut+= "*";
            }

            else  if(counter % 9 == 0)
            {
                keyOut+= "(";
            }

            else if(counter % 10 == 0)
            {
                keyOut+= "10";
            }

            else
            {
                keyOut+= "{}";
            }
            counter++;

        }//end foreach

        return keyOut;
    }//end makeFileKe





}
