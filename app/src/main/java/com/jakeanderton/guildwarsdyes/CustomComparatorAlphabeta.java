package com.jakeanderton.guildwarsdyes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

public class CustomComparatorAlphabeta implements Comparator<JSONObject>
{

    public int compare(JSONObject lhs, JSONObject rhs)
    {
        String s1 = "";
        String s2 = "";
        try
        {
            s1 = lhs.getString("name");
            s2 = rhs.getString("name");
            //    Log.i("comparing: ", s1 + " " + s2);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return s1.compareTo(s2);


    }
}
