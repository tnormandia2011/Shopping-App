package com.example.tim.shopping_app;

import android.os.AsyncTask;
import android.widget.ListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.util.List;

/**
 * Created by Tim on 4/22/2015.
 */
public class WalmartCall extends AsyncTask<String, Void, List<ItemInfo>>
{
    private Search caller;

    public WalmartCall(Search caller)
    {
        this.caller = caller;
    }

    protected List<ItemInfo> doInBackground(String... item)
    {
        try
        {
            String website = "http://api.walmartlabs.com/v1/search?query=" + item[0] + "&format=json&apiKey=qtuee8uej2ukrbruc5b6x46t";

            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet(website);
            HttpResponse response = httpClient.execute(httpGet, localContext);


            return JsonParser.buildWalmartObjects(response.getEntity().getContent());
        }
        catch (Exception e)
        {
            System.out.println("doInBackground");
            e.printStackTrace();
            return null;
        }

    }
    protected void onPostExecute(List<ItemInfo> info)
    {
        System.out.println(info.get(0).getName());
        ListView lview = (ListView)caller.findViewById(R.id.listViewSearch);
        lview.setAdapter(new MyArrayAdapter(caller, info));
    }
}

