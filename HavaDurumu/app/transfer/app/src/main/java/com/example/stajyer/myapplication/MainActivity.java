package com.example.stajyer.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    Button btn;
    EditText etName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btnSubmit);

        etName = (EditText)findViewById(R.id.et_name);

        btn.setOnClickListener(this);

    }

    private void saveUsername(String value)
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = etName.getText().toString();

        editor.putString("name","Saved in file : " + value);

        editor.commit();

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,Second.class);

        Singleton.getInstance().person = new Person();

        Singleton.getInstance().person.setName("Saved in Singleton Class : " + etName.getText().toString());

        Person person = new Person();

        person.setName(etName.getText().toString());

        intent.putExtra("person", person);

        saveUsername(person.getName());

        startActivity(intent);
    }

}
