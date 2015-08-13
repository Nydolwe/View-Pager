package com.example.stajyer.myapplication;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class Second extends ActionBarActivity {


    TextView tvClassText,tvSingletonClassText,tvSharedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        findViews();


        Intent intent = getIntent();

        Person person = (Person) intent.getParcelableExtra("person");

        tvClassText.setText(person.getName().toString());


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String name = sharedPreferences.getString("name", null);

        tvSharedText.setText(name);

        tvSingletonClassText.setText(Singleton.getInstance().person.getName());

    }

    private void findViews(){

        tvClassText = (TextView) findViewById(R.id.tvClassText);
        tvSharedText = (TextView) findViewById(R.id.tvSharedText);
        tvSingletonClassText = (TextView) findViewById(R.id.tvSingletonText);
    }
}
