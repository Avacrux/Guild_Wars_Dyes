package com.jakeanderton.guildwarsdyes;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Jake on 03/09/2015.
 */
public class DyeJsonDownloader extends AsyncTask<Void,Void,Void>
{
    public MainActivity mainActivity;
    public static JSONObject colorsObject;
    public static HashMap<Integer,JSONObject> dyeObjectList;

    public DyeJsonDownloader(MainActivity m)
    {
        mainActivity = m;

    }


    @Override
    @SuppressWarnings("deprecation")
    protected Void doInBackground(Void... params)
    {
        String dyeJsonUrl = "https://api.guildwars2.com/v1/colors.json";

        //create a httpClient
        HttpClient httpClient = new DefaultHttpClient();

        //create http request post
        HttpGet httpGet = new HttpGet(dyeJsonUrl);
        httpGet.setHeader("Content-type", "application/json");

        //create input stream to read incoming data
        InputStream inputStream;

        //try to send http request
        try{
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity  = response.getEntity();

            inputStream = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"),8);

            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null)
            {
                Log.i("Line:",line);
                stringBuilder.append(line);
            }

            String jsonData = stringBuilder.toString();
            //Log.i("jsonData:, ", jsonData);

            JSONObject jObject = new JSONObject(jsonData);
            colorsObject = jObject.getJSONObject("colors");

            //TODO: need to iterate through the objects of colors object using colorsobject.getJsonObject(index.tostring) for each color

            dyeObjectList = new HashMap<>();
            //JSONObject[] dyeObjectList = new JSONObject[total];

            Iterator keys = colorsObject.keys();

            while(keys.hasNext())
            {
                String key = (String)keys.next();
                JSONObject jsonObject = colorsObject.getJSONObject(key);
                Log.i("Print out: ", jsonObject.toString());
                dyeObjectList.put(Integer.parseInt(key), jsonObject);

            }

           mainActivity.createGridView();

            //Log.i("length: ",Integer.toString(colorsObject.length()));
            //Log.i("Print out: ",colorsObject.toString());



        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
