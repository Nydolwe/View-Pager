package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stajyer.havadurumu.R;


public class MyViewPagerFragment extends Fragment {

    public MyViewPagerFragment(){

    }



        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

            View rootView = inflater.inflate(R.layout.fragment_view_pager,container,false);
            return rootView;

        }


    public Fragment get(int i) {
        return null;
    }

}

