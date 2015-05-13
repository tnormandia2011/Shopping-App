package com.example.tim.shopping_app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.content.Context;




/**
 * Created by Tim on 5/12/2015.
 */
public class Methods extends MainActivity
{
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

    public void makeAccount(String userName, String passIn)
    {//start makeAccount
        String fileKey = makeFileKey(userName);

        int passInt = passHash(passIn);
        WriteFile((userName + fileKey + Integer.toString(passInt)), (userName + "userLogin"));

    }//end makeAccount

    public boolean checkLogin(String userName, String passIn)
    {
        String fileKey = makeFileKey(userName);
        String stringIn = ReadFile(userName + ("userLogin"));
        int fileKeyLocation = stringIn.indexOf(fileKey);
        int passHashIn = passHash(passIn);

        String grabbedUserName = stringIn.substring(0, fileKeyLocation);
        int grabbedPassHash = Integer.parseInt(stringIn.substring((fileKeyLocation + fileKey.length()), (stringIn.length() - (fileKeyLocation + fileKey.length()))));

        if (grabbedUserName == userName && passHashIn == grabbedPassHash)
            return true;

        else
            return false;
    }



    public static int passHash(String passIn)
    {//start passHash
        int passInt = passIn.length();

        try
        {//start try

            char[] passArray = passIn.toCharArray();

            for (int i = 0; i < passIn.length(); i++)
            {//start for
                passInt += Integer.parseInt(Character.toString(passArray[i]));
                passInt++;
                passInt = passInt * 19;
            }//end for

        }//end try

        catch(Exception E)
        {

        }


        passInt = passInt * 7;
        passInt = passInt + 91;
        passInt = passInt * passIn.length();
        passInt = passInt % 103049;
        passInt = passInt + 46;
        passInt = passInt * 84;

        return passInt;

    }//end passHash















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







    public static String[] setMain(String oldMain[], String newEntry)
    {//start setMain
        int currentSize = Integer.parseInt(oldMain[100]);

        if (currentSize == 100)
        {//start if
            String[] downOne = new String[101];
            downOne[100] = Integer.toString(currentSize);

            for (int i = 0; i < 99; i++)
            {//start for
                downOne[i+1] = oldMain[i];
            }//end for

            oldMain = downOne;

        }//end if

        else
        {
            currentSize++;
            oldMain[100] = Integer.toString(currentSize);
        }

        oldMain[0] = newEntry;
        return oldMain;

    }//end setMain




    public static String makeFileKey(String userName)
    {//start makeFileKey
        char[] charArray = userName.toCharArray();
        String keyOut = "";
        int counter = 1;

        for(char c : charArray)
        {//start foreach
            keyOut+= c;
            if(counter % 1 == 0)
            {
                keyOut+= "!";
            }

            else if(counter % 2 == 0)
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
