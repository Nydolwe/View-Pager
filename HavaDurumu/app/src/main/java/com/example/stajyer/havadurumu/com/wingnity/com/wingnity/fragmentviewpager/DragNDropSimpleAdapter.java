package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

/**
 * Created by stajyer on 05.08.2015.
 */
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;

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
    public View getView(int position, View view, ViewGroup group) {

        View mainView = super.getView(mPosition[position], view, group);

        final ImageButton btnSilActivate = (ImageButton) mainView.findViewById(R.id.imgDelete);
        TextView txtFavName = (TextView)mainView.findViewById(R.id.textViewFavoriText);
        final Button btnDelete = (Button) mainView.findViewById(R.id.buttonDelete);

        btnSilActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnDelete.setVisibility(btnDelete.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);

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

