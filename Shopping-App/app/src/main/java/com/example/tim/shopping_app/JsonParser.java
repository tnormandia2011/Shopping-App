package com.example.tim.shopping_app;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tim on 4/22/2015.
 */
public class JsonParser
{

        public static List<ItemInfo> buildWalmartObjects(InputStream json)
        {
            JsonReader reader = new JsonReader( new InputStreamReader(json));
            return readMessagesArray(reader);
        }

        private static List readMessagesArray(JsonReader reader)
        {
            List messages = new ArrayList();
            try
            {
                reader.beginObject();
                while(reader.hasNext())
                {
                    String name = reader.nextName();
                    if(name.equals("items"))
                    {
                        messages = readMessage(reader);
                    }

                    else
                        reader.skipValue();
                }
            }
            catch(IOException e)
            {
                System.out.println("readMessagesArray");
                e.printStackTrace();
            }
            return messages;
        }


        private static List readMessage(JsonReader reader) throws IOException
        {
            List messages = new ArrayList();

            reader.beginArray();
            while(reader.hasNext())
            {
                ItemInfo obj = new ItemInfo();

                reader.beginObject();
                while(reader.hasNext())
                {
                    String name = reader.nextName();

                    if(name.equals("name"))
                    {
                        obj.setName(reader.nextString());
                    }

                    else if(name.equals("salePrice"))
                    {
                        obj.setPrice(reader.nextDouble());
                    }
                    else if(name.equals("shortDescription"))
                    {
                        obj.setsDescription(reader.nextString());
                    }


                    else
                    {
                        reader.skipValue();
                    }
                }
                    reader.endObject();
                    messages.add(obj);
            }
            reader.endArray();
            return messages;
        }

       /* private static void readTemp(JsonReader reader, WeatherInfo obj) throws IOException
        {
            reader.beginObject();
            while(reader.hasNext())
            {
                String nextName = reader.nextName();
                if(nextName.equals("max"))
                    obj.setHigh(reader.nextDouble());
                else if(nextName.equals("min"))
                    obj.setLow(reader.nextDouble());
                else if(nextName.equals("day"))
                    obj.setDayTemp(reader.nextDouble());
                else if(nextName.equals("night"))
                    obj.setNightTemp(reader.nextDouble());
                else
                    reader.skipValue();
            }
            reader.endObject();
        }
        private static void readWeather(JsonReader reader, WeatherInfo obj) throws IOException
        {

            reader.beginArray();
            while(reader.hasNext())
            {
                reader.beginObject();
                while(reader.hasNext())
                {
                    String nextName = reader.nextName();
                    if (nextName.equals("main"))
                    {
                        obj.setMain(reader.nextString());

                    }
                    else if (nextName.equals("description"))
                    {
                        obj.setDescription(reader.nextString());
                    }
                    else if(nextName.equals("icon"))
                    {
                        obj.setIcon(reader.nextString());
                    }
                    else
                    {
                        reader.skipValue();
                    }
                }
                reader.endObject();
            }
            reader.endArray();


        }*/
}
