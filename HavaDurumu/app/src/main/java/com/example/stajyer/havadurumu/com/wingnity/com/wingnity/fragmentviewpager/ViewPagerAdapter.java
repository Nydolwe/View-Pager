package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.stajyer.havadurumu.R;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    Map<String, Object>[] items;


    public ViewPagerAdapter(FragmentManager fm, Context context){

        super(fm);


        this.context = context;
    }

    @Override
    public Fragment getItem(int position){

        MyViewPagerFragment mp = new MyViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("idx",position);
        mp.setArguments(bundle);
        return mp;

    }

    @Override
    public int getCount(){

        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        final Set<String> data = sharedPreferences.getStringSet("favs", null) ;
        HashSet<String> cities = (HashSet<String>) data;




        return cities.size();
    }

}
