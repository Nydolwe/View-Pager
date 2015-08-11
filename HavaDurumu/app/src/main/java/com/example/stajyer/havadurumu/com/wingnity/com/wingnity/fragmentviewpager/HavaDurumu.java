package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.stajyer.havadurumu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HavaDurumu extends FragmentActivity implements  GoogleMap.OnMarkerClickListener {





   // Bitmap heavyrain = BitmapFactory.decodeResource(getResources(),R.drawable.heavyrain);
   // Bitmap resized = Bitmap.createScaledBitmap(heavyrain,(int)(heavyrain.getWidth()*0.2),(int)(heavyrain.getHeight()*0.2),true);

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hava_durumu);

        final Button btnAra = (Button)findViewById(R.id.btnArama);

        final LinearLayout vw = (LinearLayout)findViewById(R.id.llSearchItems);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vw.startAnimation(AnimationUtils.loadAnimation(HavaDurumu.this, android.R.anim.slide_out_right));
                vw.getAnimation().setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        vw.setVisibility(View.GONE);
                        btnAra.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw.setVisibility(View.VISIBLE);
                btnAra.setVisibility(View.GONE);
                vw.startAnimation(AnimationUtils.loadAnimation(HavaDurumu.this, android.R.anim.slide_in_left));
            }
        });

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setZoomGesturesEnabled(false);


        mMap.addMarker(new MarkerOptions().position(new LatLng(41.0138400, 28.9496600)).title("İstanbul").snippet("Yağmurlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.heavyrain)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(38.4127300, 27.1383800)).title("İzmir").snippet("Güneşli").icon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyicon)));
       Marker a1 = mMap.addMarker(new MarkerOptions().position(new LatLng(39.9198700, 32.8542700)).title("Ankara").snippet("Bulutlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.cloud_icon)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a1.getPosition()));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), null);
    }



}
