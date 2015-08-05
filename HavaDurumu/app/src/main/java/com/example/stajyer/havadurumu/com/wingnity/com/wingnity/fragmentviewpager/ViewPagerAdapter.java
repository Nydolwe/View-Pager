package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.stajyer.havadurumu.R;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {




    public ViewPagerAdapter(FragmentManager fm){

        super(fm);

    }

    @Override
    public Fragment getItem(int position){

        MyViewPagerFragment mp = new MyViewPagerFragment();

        return mp;
    }

    @Override
    public int getCount(){



        return 7;
    }

}
