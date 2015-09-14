package com.jakeanderton.guildwarsdyes;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

public class CustomComparatorLeather implements Comparator<JSONObject>
{

    @Override
    public int compare(JSONObject lhs, JSONObject rhs)
    {
        Integer i1 = 0;
        Integer i2 = 0;
        try
        {
             i1 = lhs.getJSONObject("leather").getInt("hue");
             i2 = rhs.getJSONObject("leather").getInt("hue");
            Log.i("comparing: ", i1 + " " + i2);


        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return i1.compareTo(i2);

    }
}
