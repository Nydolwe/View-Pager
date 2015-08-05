package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import com.example.stajyer.havadurumu.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Favoriler extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriler);
        int lv = 5;
        ArrayList<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < lv; ++i) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("name", "item" + i);
            item.put("_id", i);
            items.add(item);
        }
        DragNDropListView list = (DragNDropListView)findViewById(R.id.listViewDragDrop);
        list.setDragNDropAdapter(new DragNDropSimpleAdapter(this,
                items,
                R.layout.row,
                new String[]{"name"},
                new int[]{R.id.textViewFavoriText},
                R.id.handler,list));
        list.setOnItemDragNDropListener(new DragNDropListView.OnItemDragNDropListener() {
            @Override
            public void onItemDrag(DragNDropListView parent, View view, int position, long id) {
            }

            @Override
            public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id) {
            }
        });
    }
}

