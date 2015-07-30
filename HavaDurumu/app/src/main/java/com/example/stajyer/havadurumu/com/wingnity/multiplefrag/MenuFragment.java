package com.example.stajyer.havadurumu.com.wingnity.multiplefrag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.stajyer.havadurumu.R;

public class MenuFragment extends Fragment{

    Fragment frag;
    FragmentTransaction fragTransaction;

    public MenuFragment(){



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_multi,container,false);

        frag = new KoalaFragment();
        fragTransaction = getFragmentManager().beginTransaction().add(R.id.container,frag);
        fragTransaction.commit();

        Button btnKoala =(Button)view.findViewById(R.id.buttonKoala);
        Button btnPenguin =(Button)view.findViewById(R.id.buttonPenguin);
        Button btnOther =(Button)view.findViewById(R.id.buttonOther);

        btnKoala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag = new KoalaFragment();
                fragTransaction = getFragmentManager().beginTransaction().replace(R.id.container, frag);
                fragTransaction.commit();

            }
        });
        btnPenguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag = new PenguinFragment();
                fragTransaction = getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();

            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag = new OtherFragment();
                fragTransaction = getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();

            }
        });

        return view;
    }
}
