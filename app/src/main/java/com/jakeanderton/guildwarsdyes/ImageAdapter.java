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
    private Object[] dyeList;

    public ImageAdapter(Context c)
    {
        mContext = c;
        dyeList = generateDyeList();

    }

    private Object[] generateDyeList()
    {

        return (DyeJsonDownloader.dyeObjectList).values().toArray();

    }

    @Override
    public int getCount()
    {
        return DyeJsonDownloader.dyeObjectList.size();
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
            dye = (DyeColor)convertView;
        }

        JSONObject jo =(JSONObject) dyeList[position];



        try
        {
            Log.i("jo printout:", jo.toString());
            JSONObject leather = jo.getJSONObject("leather");
            Log.i("leather:",leather.toString());
            JSONArray rgb = leather.getJSONArray("rgb");
            Log.i("rgb:",rgb.toString());
            int r;
            int g;
            int b;
            r = rgb.getInt(0);
            g = rgb.getInt(1);
            b = rgb.getInt(2);
            Log.i("r:", String.valueOf(r));
            Log.i("g:", String.valueOf(g));
            Log.i("b:", String.valueOf(b));

            Color c = new Color();

            dye.setBackgroundColor(c.rgb(r,g,b));


        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        //dye.setImageResource(mThumbIds[position]);
        //dye.setBackgroundColor(c);
        return dye;


    }

    private Integer[] mThumbIds =
            {
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7,
                    R.drawable.sample_0, R.drawable.sample_1,
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7,
                    R.drawable.sample_0, R.drawable.sample_1,
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7
            };

}
