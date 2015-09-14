package com.jakeanderton.guildwarsdyes;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jake on 04/09/2015.
 */
public class ImageAdapter extends BaseAdapter
{
    private Context mContext;
    private int mode = 0;

    public ImageAdapter(Context c,int m)
    {
        mContext = c;
        mode = m;
    }

    @Override
    public int getCount()
    {
        return DyeSorter.sortedList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        DyeColor dye;

        if (convertView == null)
        {
            dye = new DyeColor(mContext);
            dye.setLayoutParams(new GridView.LayoutParams(100, 100));
            dye.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dye.setPadding(8, 8, 8, 8);

        }
        else
        {
            dye = (DyeColor) convertView;
        }

        try
        {
            JSONObject jo;
            if(mode == 1)//colour order
            {
                 jo = (JSONObject) DyeSorter.sortedList.get(position);
              // Log.i("color order","" +jo.getString("name"));

            }
            else if(mode == 2)//alphabetical
            {
                 jo = (JSONObject) DyeSorter.alphabetaSortedList.get(position);
            }
            else
            {
                jo = new JSONObject();
            }

           // Log.i("jo printout:", jo.toString());
            JSONObject leather = jo.getJSONObject("leather");
           // Log.i("leather:", leather.toString());
            JSONArray rgb = leather.getJSONArray("rgb");
            //Log.i("rgb:", rgb.toString());
            int r;
            int g;
            int b;
            r = rgb.getInt(0);
            g = rgb.getInt(1);
            b = rgb.getInt(2);
            //Log.i("r:", String.valueOf(r));
            //Log.i("g:", String.valueOf(g));
           // Log.i("b:", String.valueOf(b));

            Color c = new Color();

            dye.setBackgroundColor(c.rgb(r, g, b));

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            Log.i("thing:",Integer.toString(position));
        }

        return dye;

    }



}
