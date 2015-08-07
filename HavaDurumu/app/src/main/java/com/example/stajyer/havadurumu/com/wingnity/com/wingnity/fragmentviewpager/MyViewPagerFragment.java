package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;
import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.model.Weather;

import org.json.JSONException;

import java.util.HashSet;
import java.util.Set;


public class MyViewPagerFragment extends Fragment {
    public MyViewPagerFragment() {

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        TextView sehir =(TextView)rootView.findViewById(R.id.txtSehir);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final Set<String>  data = sharedPreferences.getStringSet("spinnerS", null) ;
        HashSet<String> cities = (HashSet<String>) data; 
        sehir.setText(data.toArray()[0].toString().split("#")[1]);

        TextView ulke =(TextView)rootView.findViewById(R.id.txtUlke);
        SharedPreferences sharedPreferencesUlke = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final String  dataulke = sharedPreferences.getString("spinnerC","") ;
        ulke.setText(dataulke.toString());



        return rootView;
    }
        public Fragment get(int i) {
            return null;
        }

    }

