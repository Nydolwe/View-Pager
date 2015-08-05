package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

/**
 * Created by stajyer on 05.08.2015.
 */
import android.widget.ListAdapter;

public interface DragNDropAdapter extends ListAdapter, DragNDropListView.OnItemDragNDropListener {
    public int getDragHandler();
}
