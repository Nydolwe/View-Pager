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

public class ViewPagerActivity extends ActionBarActivity {


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;

        ViewPager pager;
        ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
       pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                imageView1.setBackgroundResource(R.drawable.circle_blue);
                imageView2.setBackgroundResource(R.drawable.circle_blue);
                imageView3.setBackgroundResource(R.drawable.circle_blue);
                imageView4.setBackgroundResource(R.drawable.circle_blue);
                imageView5.setBackgroundResource(R.drawable.circle_blue);
                if(position == 0)
                    imageView1.setBackgroundResource(R.drawable.circle_black);
                else if(position == 1)
                    imageView2.setBackgroundResource(R.drawable.circle_black);
                else if(position == 2)
                    imageView3.setBackgroundResource(R.drawable.circle_black);
                else if(position == 3)
                    imageView4.setBackgroundResource(R.drawable.circle_black);
                else if(position == 4)
                    imageView5.setBackgroundResource(R.drawable.circle_black);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
