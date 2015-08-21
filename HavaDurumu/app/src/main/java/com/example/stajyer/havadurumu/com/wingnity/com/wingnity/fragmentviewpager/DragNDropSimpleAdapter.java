package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

/**
 * Created by stajyer on 05.08.2015.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stajyer.havadurumu.R;

import static com.google.android.gms.internal.zzhl.runOnUiThread;

public class DragNDropSimpleAdapter extends SimpleAdapter implements DragNDropAdapter {
    private int mPosition[];
    private int mHandler;
    DragNDropListView lv;


    private List<? extends Map<String, ?>> dataList;

    public DragNDropSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
                                  int[] to, int handler,DragNDropListView lv) {
        super(context, data, resource, from, to);

        mHandler = handler;
        dataList = data;
        this.lv = lv;
        setup(data.size());
    }

    private void setup(int size) {
        mPosition = new int[size];

        for (int i = 0; i < size; ++i)
            mPosition[i] = i;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup group) {

        View viewMain = super.getDropDownView(mPosition[position], view, group);


        return viewMain;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(mPosition[position]);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(mPosition[position]);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(mPosition[position]);
    }

    @Override
    public View getView(final int position, View view, ViewGroup group) {

        View mainView = super.getView(mPosition[position], view, group);

        final ImageButton btnSilActivate = (ImageButton) mainView.findViewById(R.id.imgDelete);
        TextView txtFavName = (TextView)mainView.findViewById(R.id.textViewFavoriText);
        final Button btnDelete = (Button) mainView.findViewById(R.id.buttonDelete);

        btnSilActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnDelete.setVisibility(btnDelete.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);

                for(int i=0;i<lv.getChildCount();i++){
                    View vv =  lv.getChildAt(i);
                    if(!vv.findViewById(R.id.buttonDelete).equals(btnDelete)){
                        vv.findViewById(R.id.buttonDelete).setVisibility(View.INVISIBLE);
                    }
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(DefaultApplication.context);

                Set<String> data = sharedPreferences.getStringSet("favs", null);

                String[] array = data.toArray(new String[data.size()]);
                if (data.size()<=1){

                    Toast.makeText(DefaultApplication.context, "Lütfen yeni favori ekleyip tekrar deneyiniz",
                            Toast.LENGTH_LONG).show();


                }
                else {

                    ArrayList<String> arrayList = new ArrayList<String>();

                    for (String s : array) {

                        if (!dataList.get(position).get("name").toString().toLowerCase().contains(s.split(",")[0].toLowerCase())) {

                            arrayList.add(s);

                        }

                    }

                    data.clear();

                    for (String s : arrayList
                            ) {
                        data.add(s);
                    }

                    sharedPreferences.edit().putStringSet("favs", data);
                    sharedPreferences.edit().commit();

                    HashSet<String> cities = (HashSet<String>) data;

                    Map<String, Object>[] items = new Map[cities.size()];

                    for (int i = 0; i < cities.size(); i++) {


                        HashMap<String, Object> item = new HashMap<String, Object>();

                        item.put("name", data.toArray()[i].toString().split(",")[0] + " - " + data.toArray()[i].toString().split(",")[1]);

                        item.put("country", data.toArray()[i].toString().split(",")[1]);

                        items[i] = item;

                    }

                    dataList = new ArrayList<Map<String, Object>>(Arrays.asList(items));

                    DragNDropSimpleAdapter.this.notifyDataSetChanged();


                }
            }

        });

        return mainView;
    }

    @Override
    public boolean isEnabled(int position) {
        return super.isEnabled(mPosition[position]);
    }

    @Override
    public void onItemDrag(DragNDropListView parent, View view, int position, long id) {

    }

    @Override
    public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id) {
        int position = mPosition[startPosition];

        if (startPosition < endPosition)
            for (int i = startPosition; i < endPosition; ++i)
                mPosition[i] = mPosition[i + 1];
        else if (endPosition < startPosition)
            for (int i = startPosition; i > endPosition; --i)
                mPosition[i] = mPosition[i - 1];

        mPosition[endPosition] = position;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public void notifyDataSetChanged() {
        setup(dataList.size());
        super.notifyDataSetChanged();
    }

    @Override
    public int getDragHandler() {
        return mHandler;
    }
}

