package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.app.Application;
import android.content.Context;

/**
 * Created by stajyer on 10.08.2015.
 */
public class DefaultApplication extends Application {

    public  static Context context;

    @Override
    public void onCreate() {

        super.onCreate();

        context = getApplicationContext();

    }
}
