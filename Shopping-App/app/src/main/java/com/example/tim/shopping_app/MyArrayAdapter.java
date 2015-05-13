package com.example.tim.shopping_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tim on 4/29/2015.
 */
public class MyArrayAdapter extends BaseAdapter
{
    private Context context;
    private List<ItemInfo> infolist;
    private static LayoutInflater inflater = null;

    public MyArrayAdapter(Context context, List<ItemInfo> values)
    {
        this.context = context;
        this.infolist = values;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return infolist.size();
    }
    @Override
    public Object getItem(int position)
    {
        return position;
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    public class Holder
    {
        TextView tv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder = new Holder();
        View rowview;
        rowview = inflater.inflate(R.layout.layout,null);
        holder.tv = (TextView)rowview.findViewById(R.id.textView3);
        holder.tv.setText(infolist.get(position).toString());

        final Button search = (Button) rowview.findViewById(R.id.button);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myintent = new Intent(context, Results.class);
                ItemInfo theItem = infolist.get(position);
                String info = theItem.getInfo();
                myintent.putExtra("info", info);
                context.startActivity(myintent);
            }
        });


        return rowview;

    }
}
