package com.jakeanderton.guildwarsdyes;

import android.content.Context;
import android.widget.ImageView;

public class DyeColor extends ImageView
{
    public int id;
    public String name;
    public int[] base_rgb = new int[2];



    public DyeColor(Context context,int i,String n,int[] b_rgb)
    {
        super(context);
        id = i;
        name = n;
        base_rgb = b_rgb;
    }

    public DyeColor(Context context) {
        super(context);

    }

    //Todo set up onclick to display the name of the color,


}
