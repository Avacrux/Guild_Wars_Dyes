package com.jakeanderton.guildwarsdyes;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jake on 11/09/2015.
 */
public class DyeSorter
{

    //static TreeMap treeMap = new TreeMap();
    public static ArrayList<JSONObject> sortedList;
    public static ArrayList<JSONObject> alphabetaSortedList;

    public MainActivity mainActivity;
    //public static Object[] sortedList;
   // public static Object[] unsortedList;

    public DyeSorter(MainActivity m)
    {
        mainActivity = m;
        //unsortedList = (DyeJsonDownloader.dyeObjectList.values().toArray());
        sortList();
        //sortedList = generateSortedList();
    }

//    private Object[] generateSortedList()
//    {
//
//        return treeMap.values().toArray();
//
//    }

    private void sortList()
    {
        sortedList = new ArrayList<>(DyeJsonDownloader.dyeObjectList);
        alphabetaSortedList = new ArrayList<>(DyeJsonDownloader.dyeObjectList);
        Collections.sort(sortedList, new CustomComparatorLeather());
        Collections.sort(alphabetaSortedList, new CustomComparatorAlphabeta());


        mainActivity.createGridView();


    }



//    private void sortList()
//    {
//        int loopNo = 0;
//        JSONObject jo;
//        int i;
//       // i = dyeList.length;
//      //  Log.i("Dye List length: ", "" + i + "");
//
//        //for ( Object o :  dyeList)
//        for (loopNo = 0; loopNo < unsortedList.length; loopNo++)
//        {
//
//            try
//            {
//                if(unsortedList[loopNo] != null)
//                {
//                    jo = (JSONObject)unsortedList[loopNo];
//                    JSONObject jol = jo.getJSONObject("leather");
//                    int hue = jol.getInt("hue");
//                    Log.i("Sorting " + loopNo + ":", "" + hue + "");
//
//                    treeMap.put(hue, jo);
//                }
//                else
//                {
//                    Log.i("null object at loop " ,"" + loopNo);
//                }
//
//
//
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//                Log.i("Loop: ",""+loopNo+"");
//            }
//
//            Log.i("Done Sorting, ", ""+ treeMap.size());
//
//
//        }
//
//    }


}


