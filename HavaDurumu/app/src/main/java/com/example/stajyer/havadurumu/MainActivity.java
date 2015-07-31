package com.example.stajyer.havadurumu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.ViewPagerActivity;
import com.example.stajyer.havadurumu.com.wingnity.multiplefrag.MultiFragActivity;
import com.example.stajyer.havadurumu.com.wingnity.simplefrag.SimpleFragmentActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void simple(View v){

        Intent intent = new Intent(getApplicationContext(), SimpleFragmentActivity.class);
        startActivity(intent);

    }
    public void multiple(View v){

        Intent intent = new Intent(getApplicationContext(), MultiFragActivity.class);
        startActivity(intent);

    }

    public void pager(View v){

        Intent intent = new Intent(getApplicationContext(), ViewPagerActivity.class);
        startActivity(intent);



    }

}
