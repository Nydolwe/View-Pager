package com.example.stajyer.havadurumu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.Favoriler;
import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.Main2Activity;
import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.MyViewPagerFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends ActionBarActivity {
    Spinner spinnerC;
    Spinner spinnerS;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String issaved = sharedPreferences.getString("spinnerC", null);

        if (issaved != null) {


            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
        } else {

            spinnerC = (Spinner)findViewById(R.id.spinnerC);
            spinnerS = (Spinner)findViewById(R.id.spinnerS);

            ArrayAdapter adapterC = ArrayAdapter.createFromResource(this, R.array.Countrys, android.R.layout.simple_spinner_item);
            spinnerC.setAdapter(adapterC);


            ArrayAdapter adapterIS = ArrayAdapter.createFromResource(this, R.array.Turkey, android.R.layout.simple_spinner_item);
            spinnerS.setAdapter(adapterIS);

            spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String country = MainActivity.this.getResources().getStringArray(R.array.Countrys)[position];

                    if (country.equals("Almanya")) {
                        ArrayAdapter adapterS;
                        adapterS = ArrayAdapter.createFromResource(MainActivity.this, R.array.Germany, android.R.layout.simple_spinner_item);
                        spinnerS.setAdapter(adapterS);
                    } else if (country.equals("Ingiltere")) {
                        ArrayAdapter adapterS = ArrayAdapter.createFromResource(MainActivity.this, R.array.England, android.R.layout.simple_spinner_item);
                        spinnerS.setAdapter(adapterS);
                    } else {


                        ArrayAdapter adapterIS = ArrayAdapter.createFromResource(MainActivity.this, R.array.Turkey, android.R.layout.simple_spinner_item);
                        spinnerS.setAdapter(adapterIS);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

    }

    public void pager(View v){


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> sets = new HashSet<>();
        String city2 = "1#"+"İstanbul"+"#"+spinnerC.getSelectedItem().toString();
        sets.add(city2);
        String city = "0#"+spinnerS.getSelectedItem().toString()+"#"+spinnerC.getSelectedItem().toString();
        sets.add(city);


        editor.putStringSet("spinnerS", sets);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);


       }










    }




