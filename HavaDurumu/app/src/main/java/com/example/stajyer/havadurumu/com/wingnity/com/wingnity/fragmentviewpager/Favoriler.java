package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.stajyer.havadurumu.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Favoriler extends ActionBarActivity  {


    String cityNew;
    ImageButton imgButton;

    Map<String, Object>[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriler);




            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            Set<String> data = sharedPreferences.getStringSet("favs", null);


            HashSet<String> cities = (HashSet<String>) data;

        items = new  Map[cities.size()];

        for(int i = 0; i < cities.size(); i++) {


            HashMap<String, Object> item = new HashMap<String, Object>();

            item.put("name",data.toArray()[i].toString().split(",")[0] +" - " +data.toArray()[i].toString().split(",")[1] );

            item.put("country", data.toArray()[i].toString().split(",")[1]);

            items[i] = item;

        }

        final DragNDropListView list = (DragNDropListView)findViewById(R.id.listViewDragDrop);
        list.setDragNDropAdapter(new DragNDropSimpleAdapter(this,
                new ArrayList<Map<String, Object>>(Arrays.asList(items)),
                R.layout.row,
                new String[]{"name"},
                new int[]{R.id.textViewFavoriText},
                R.id.handler, list));

        list.setOnItemDragNDropListener(new DragNDropListView.OnItemDragNDropListener() {
            @Override
            public void onItemDrag(DragNDropListView parent, View view, int position, long id) {


            }

            @Override
            public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id) {

                SharedPreferences sprefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sprefs.edit();

                final Set<String> data = sprefs.getStringSet("favs", null);


                String array[] = data.toArray(new String[data.size()]);
                String temp = array[startPosition];
                array[startPosition] = array[endPosition];
                array[endPosition] = temp;

                Set<String> tempS = new HashSet<String>(Arrays.asList(array));


                editor.putStringSet("favs", tempS);

                editor.commit();


            }
        });


        }


    }





