package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MyViewPagerFragment extends Fragment {
    Map<String, Object>[] items;
    Context context;

    public MyViewPagerFragment() {


    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        idx = args.getInt("idx");

    }

    public TextView sehir;

    public TextView ulke;

    public int idx;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        sehir =(TextView)rootView.findViewById(R.id.txtSehir);

        ulke =(TextView)rootView.findViewById(R.id.txtUlke);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final Set<String> data = sharedPreferences.getStringSet("spinnerS", null) ;

        HashSet<String> cities = (HashSet<String>) data;

        items = new  Map[cities.size()];

        for(int i = 0; i < cities.size(); ++i) {

            if(idx == i) {

                sehir.setText(data.toArray()[i].toString().split("#")[1] + i);

                ulke.setText(data.toArray()[i].toString().split("#")[2]);

            }

        }
        return rootView;
    }
        public Fragment get(int i) {
            return null;
        }

    }

