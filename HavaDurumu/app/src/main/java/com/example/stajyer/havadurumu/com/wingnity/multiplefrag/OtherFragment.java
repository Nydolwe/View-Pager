package com.example.stajyer.havadurumu.com.wingnity.multiplefrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.stajyer.havadurumu.R;


public class OtherFragment extends Fragment {

    public OtherFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_multi_other,container,false);
        Button btnMulti = (Button)rootView.findViewById(R.id.btnMultiOther);

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Clicked Button", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }
}
