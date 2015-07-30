package com.example.stajyer.havadurumu.com.wingnity.simplefrag;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.stajyer.havadurumu.R;

public class SimpleFragmentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        if (savedInstanceState == null){

            PlaceholderFragment pf = new PlaceholderFragment();

            getFragmentManager().beginTransaction().add(R.id.container,pf).commit();

        }
    }


    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment(){

        }

                    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState  ){

                        View rootView = inflater.inflate(R.layout.fragment_simple,container,false);

                        Button btnclickmePenguin = (Button)rootView.findViewById(R.id.btnSimpleFragPenguin);
                        btnclickmePenguin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity(),"Clicked Penguin",Toast.LENGTH_SHORT).show();
                            }
                        });

                        return rootView;

                    }

    }
}
