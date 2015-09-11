package com.jakeanderton.guildwarsdyes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

public class CustomComparator implements Comparator<JSONObject>
{

    @Override
    public int compare(JSONObject lhs, JSONObject rhs)
    {
        Integer i1 = 0;
        Integer i2 = 0;
        try
        {
             i1 = lhs.getJSONObject("leather").getInt("hue");
             i2 = lhs.getJSONObject("leather").getInt("hue");


        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return i1.compareTo(i2);
    }
}