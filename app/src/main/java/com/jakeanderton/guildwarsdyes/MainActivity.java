package com.jakeanderton.guildwarsdyes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends ActionBarActivity
{
    DyeSorter sorter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DyeJsonDownloader(this).execute();

    }

    public void startSorter()
    {
        sorter = new DyeSorter(this);
    }

    public void createGridView()
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                GridView gridView = (GridView) findViewById(R.id.gridView1);
                final ImageAdapter adapter = new ImageAdapter(MainActivity.this,1);

                gridView.setAdapter(adapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        JSONObject jo = (JSONObject) DyeSorter.sortedList.get(position);
                        String name;
                        try
                        {
                            name = (jo.get("name")).toString();
                            adapter.getItem(position);
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                            //View v = factory.inflate(R.layout.alert_popup, null);

                            DyeColor d = new DyeColor(MainActivity.this);

                            d.setBackgroundColor(adapter.getColorLeather(position));

                            builder.setView(d);

                            builder.setTitle(name);
                            builder.setNegativeButton("Close", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {

                                }
                            });


                            AlertDialog dialog = builder.create();
                            dialog.show();
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
        if (id == R.id.alphabeta_menu)
        {
            Intent openAlphaBeta = new Intent(this,AlphabetaActivity.class);
            startActivity(openAlphaBeta);
        }

        if (id == R.id.alphabeta_menu)
        {
            Intent openAlphaBeta = new Intent(this,AlphabetaActivity.class);
            startActivity(openAlphaBeta);
        }

        return super.onOptionsItemSelected(item);
    }
}
