package com.jakeanderton.guildwarsdyes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DyeJsonDownloader(this).execute();

    }

    public void createGridView()
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                GridView gridView = (GridView) findViewById(R.id.gridView1);
                final ImageAdapter adapter = new ImageAdapter(MainActivity.this);

                gridView.setAdapter(adapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        JSONObject jo = (JSONObject) adapter.dyeList[position];
                        String name;
                        try
                        {
                            name = (jo.get("name")).toString();
                            adapter.getItem(position);
                            Toast.makeText(MainActivity.this, "" + name, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                });

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        //Todo add way to toggle the material type
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
