package com.example.stajyer.havadurumu.com.wingnity.multiplefrag;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.stajyer.havadurumu.R;

public class MultiFragActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_frag);

        if (savedInstanceState == null){


            MenuFragment mf = new MenuFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.menuContainer,mf).commit();

        }

    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment(){



        }


    }

}
