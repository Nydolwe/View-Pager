package com.example.stajyer.havadurumu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager.Main2Activity;



public class MainActivity extends ActionBarActivity {
    Spinner spinnerC;
    Spinner spinnerS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerC = (Spinner)findViewById(R.id.spinnerC);
        spinnerS = (Spinner)findViewById(R.id.spinnerS);
        ArrayAdapter adapterC = ArrayAdapter.createFromResource(this, R.array.Countrys, android.R.layout.simple_spinner_item);
        spinnerC.setAdapter(adapterC);
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.States,android.R.layout.simple_spinner_item);
        spinnerS.setAdapter(adapterS);


    }





    public void pager(View v){

        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);



    }

}
