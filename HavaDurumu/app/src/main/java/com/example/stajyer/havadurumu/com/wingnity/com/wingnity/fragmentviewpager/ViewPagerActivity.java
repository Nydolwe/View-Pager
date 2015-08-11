package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ViewPagerActivity extends ActionBarActivity {
    Context context;
    int favCont = 0;
    ArrayList<ImageView> imageViewDots;
    ViewPager pager;
    ViewPagerAdapter adapter;
    LinearLayout llContainer;
    private ActionBar actionBar;

    private ListView navlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        navlist =(ListView)findViewById(R.id.navlist);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        llContainer = (LinearLayout) findViewById(R.id.llDotContai);
        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
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

                TextView sehir =(TextView)findViewById(R.id.txtSehir);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                final Set<String> data = sharedPreferences.getStringSet("spinnerS", null) ;
                HashSet<String> cities = (HashSet<String>) data;

                for(int i = 0; i < cities.size(); ++i) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


                    sehir.setText(data.toArray()[i].toString());
                }

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

    }

    private void generatePageDots(){
        for (int i = 0;i<favCont;i++){
            ImageView imgView = new ImageView(this);
            if (i==0){
                imgView.setImageResource(R.drawable.circle_black);
            }
            else{
                imgView.setImageResource(R.drawable.circle_blue);
            }
            int width = 210;
            int height = 35;
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
            imgView.setLayoutParams(parms);
            imageViewDots.add(imgView);
            llContainer.addView(imgView);
            imgView.requestLayout();
        }
    }
}
