package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.stajyer.havadurumu.R;
import com.example.stajyer.havadurumu.com.wingnity.simplefrag.SimpleFragmentActivity;

import java.util.ArrayList;

public class ViewPagerActivity extends ActionBarActivity {


    int favCont = 0;

    ArrayList<ImageView> imageViewDots;


        ViewPager pager;
        ViewPagerAdapter adapter;
     LinearLayout llContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
         llContainer = (LinearLayout) findViewById(R.id.llDotContai);

       pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        favCont =adapter.getCount();
        imageViewDots = new ArrayList<>();
        generatePageDots();
                pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int idx = 0;
                for (ImageView imageView: imageViewDots){

                    imageView.setImageResource(R.drawable.circle_blue);

                    if(idx == position)
                        imageView.setImageResource(R.drawable.circle_black);

                    idx++;

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void generatePageDots(){

        for (int i = 0;i<favCont;i++){

            ImageView imgView = new ImageView(this);
            imgView.setImageResource(R.drawable.circle_blue);
            int width = 20;
            int height = 20;
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
            imgView.setLayoutParams(parms);
            imageViewDots.add(imgView);
            llContainer.addView(imgView);
            imgView.requestLayout();

        }

    }

}