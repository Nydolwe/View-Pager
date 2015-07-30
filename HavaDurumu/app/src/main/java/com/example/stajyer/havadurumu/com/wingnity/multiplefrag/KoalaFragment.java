package com.example.stajyer.havadurumu.com.wingnity.multiplefrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stajyer.havadurumu.R;


public class KoalaFragment extends Fragment {

    public KoalaFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_multi_koala,null);
        return rootView;
    }
}
