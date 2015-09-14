package com.jakeanderton.guildwarsdyes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class AlphabetaActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabeta);

        GridView gridView = (GridView) findViewById(R.id.alphaGridView);
        final ImageAdapter alphaAdapter = new ImageAdapter(AlphabetaActivity.this,2);

        gridView.setAdapter(alphaAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                JSONObject jo = (JSONObject) DyeSorter.alphabetaSortedList.get(position);
                String name;
                try
                {
                    name = (jo.get("name")).toString();
                    alphaAdapter.getItem(position);
                    Toast.makeText(AlphabetaActivity.this, "" + name, Toast.LENGTH_SHORT).show();
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        });

    }


    protected void onStop()
    {
        super.onStop();
    }

}
